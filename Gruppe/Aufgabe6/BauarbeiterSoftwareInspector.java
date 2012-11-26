/* auto-generated - change in class_generator.py */
import java.util.List;

public class BauarbeiterSoftwareInspector extends SoftwareInspector {
  public BauarbeiterSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(BauarbeiterSoftware s) { return droids; }
}
