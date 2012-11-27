/* auto-generated - change in class_generator.py */
import java.util.List;

public class ServiceTechnikerSoftware extends Software {
  public ServiceTechnikerSoftware(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
