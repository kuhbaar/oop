/* auto-generated - change in class_generator.py */
import java.util.List;

public class HilfskraftSoftwareInspector extends SoftwareInspector {
  public HilfskraftSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(HilfskraftSoftware s) { return droids; }
}
