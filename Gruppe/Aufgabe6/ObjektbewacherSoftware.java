import java.util.List;

public class ObjektbewacherSoftware extends Software {
  public ObjektbewacherSoftware(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
