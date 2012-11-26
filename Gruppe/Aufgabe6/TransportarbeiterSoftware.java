import java.util.List;

public class TransportarbeiterSoftware extends Software {
  public TransportarbeiterSoftware(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
