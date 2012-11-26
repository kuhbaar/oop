import java.util.List;

public class ServiceTechnikerSoftwareInspector extends SoftwareInspector {
  public ServiceTechnikerSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(ServiceTechnikerSoftware s) { return droids; }
}
