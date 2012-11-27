#!/usr/bin/python
from string import Template
import time

middleclass_template = Template("""import java.util.List;

public abstract class $classname extends $superclass {
  public $classname(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
""")

bottomclass_template = Template("""import java.util.List;

public class $classname extends $superclass {
  public $classname(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
""")

rootclass = Template("""import java.util.List;

public abstract class $classname {
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public String getSerial() {
    return seriennr;
  }

  public Sicherheitsstufe getSecurity() {
    return sw.getSecurity();
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public List<Android> inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public List<Android> inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }

  public List<Android> inspectSecurity(SicherheitsstufenInspector visitor) {
    return sw.inspectSecurity(visitor);
  }
}
""")

software_template = Template("""import java.util.List;

public class $classname extends Software {
  public $classname(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
""")

software_inspector_template = Template("""import java.util.List;

public class $classname extends SoftwareInspector {
  public $classname(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit($softwarename s) { return droids; }
}
""")


droids = ("Android",
  [
  ("Bediener", [("Hilfskraft", []), ("Gesellschafter", [])]),
  ("Schwerarbeiter", [("Bauarbeiter", []),
                      ("ServiceTechniker", []),
                      ("Transportarbeiter", [])]),
  ("Beschuetzer", [("Objektbewacher", []),
                   ("Leibwaechter", []),
                   ("Kaempfer", [])])
  ])

prefix = time.strftime("/* auto-generated - change in class_generator.py */\n")


def create_droid(droid, supercls):
  name, subclasses = droid

  f = open("Gruppe/Aufgabe6/%s.java" % name, "w")

  if supercls == "":
    f.write(prefix + rootclass.substitute(classname=name, superclass=supercls))
  elif subclasses == []:
    with open("Gruppe/Aufgabe6/%sSoftware.java" % name, "w") as g:
      g.write(prefix + software_template.substitute(classname="%sSoftware" % name))
    with open("Gruppe/Aufgabe6/%sSoftwareInspector.java" % name, "w") as g:
      g.write(prefix + software_inspector_template.substitute(classname="%sSoftwareInspector" % name,
        softwarename="%sSoftware" % name))

    f.write(prefix + bottomclass_template.substitute(classname=name, superclass=supercls))
  else:
    f.write(prefix + middleclass_template.substitute(classname=name, superclass=supercls))

  f.close()

  for cls in subclasses:
    create_droid(cls, name)

create_droid(droids, "")

security_inspector = """import java.util.List;

public class Stufe%dSoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe%dSoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe%d s) { return droids; }
}
"""

security = """import java.util.List;

public class Sicherheitsstufe%d extends Sicherheitsstufe {
  public List<Android> accept(SicherheitsstufenInspector visitor) {
    return visitor.visit(this);
  }
}

"""

for i in range(1, 6):
  with open("Gruppe/Aufgabe6/Stufe%dSoftwareSicherheitsInspector.java" % i, "w") as f:
    f.write(prefix + security_inspector % (i, i, i))
  with open("Gruppe/Aufgabe6/Sicherheitsstufe%d.java" % i, "w") as f:
    f.write(prefix + security % (i))
