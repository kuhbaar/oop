import java.util.List;

public class BauarbeiterSoftware extends Software {
  public BauarbeiterSoftware(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
