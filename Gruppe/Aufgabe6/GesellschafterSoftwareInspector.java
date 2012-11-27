/* auto-generated - change in class_generator.py */
import java.util.List;

public class GesellschafterSoftwareInspector extends SoftwareInspector {
  public GesellschafterSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(GesellschafterSoftware s) { return droids; }
}
