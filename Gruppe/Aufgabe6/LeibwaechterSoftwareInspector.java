import java.util.List;

public class LeibwaechterSoftwareInspector extends SoftwareInspector {
  public LeibwaechterSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(LeibwaechterSoftware s) { return droids; }
}
