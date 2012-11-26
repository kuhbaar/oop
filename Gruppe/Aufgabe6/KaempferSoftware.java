/* auto-generated - change in class_generator.py */
import java.util.List;

public class KaempferSoftware extends Software {
  public KaempferSoftware(String serial, Sicherheitsstufe stufe) {
    super(serial, stufe);
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
