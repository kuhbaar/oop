import java.util.List;

public class KaempferSoftwareInspector extends SoftwareInspector {
  public KaempferSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(KaempferSoftware s) { return droids; }
}
