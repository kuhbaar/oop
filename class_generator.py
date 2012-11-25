from string import Template

subclasses_template = Template("""public class $classname extends $superclass {
  public $classname(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
""")

rootclass = Template("""public class $classname {
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }

  public boolean inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }
}

""")


droid = ("Android",
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
  else:
    f.write(subclasses_template.substitute(classname=name, superclass=supercls))

  f.close()

  for cls in subclasses:
    create_droid(cls, name)

create_droid(droid, "")
