import java.util.List;

public class TransportarbeiterSoftwareInspector extends SoftwareInspector {
  public TransportarbeiterSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(TransportarbeiterSoftware s) { return droids; }
}
