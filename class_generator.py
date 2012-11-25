#!/usr/bin/python
from string import Template

middleclass_template = Template("""public abstract class $classname extends $superclass {
  public $classname(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
""")

bottomclass_template = Template("""public class $classname extends $superclass {
  public $classname(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
""")

rootclass = Template("""public abstract class $classname {
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public boolean inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public boolean inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }
}
""")

software_template = Template("""
public class $classname extends Software {
  public $classname(String serial, int sicherheitsstufe) {
    super(serial, sicherheitsstufe);
  }
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


def create_droid(droid, supercls):
  name, subclasses = droid

  f = open("Gruppe/Aufgabe6/%s.java" % name, "w")

  if supercls == "":
    f.write(rootclass.substitute(classname=name, superclass=supercls))
  elif subclasses == []:
    with open("Gruppe/Aufgabe6/%sSoftware.java" % name, "w") as g:
      g.write(software_template.substitute(classname="%sSoftware" % name))
    f.write(bottomclass_template.substitute(classname=name, superclass=supercls))
  else:
    f.write(middleclass_template.substitute(classname=name, superclass=supercls))

  f.close()

  for cls in subclasses:
    create_droid(cls, name)

create_droid(droids, "")
