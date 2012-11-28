import java.util.List;
import java.util.ArrayList;

public abstract class SoftwareInspector {
  protected final List<Android> droids;

  public SoftwareInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Software s) {
    Debug.println("ungueltige Software");
    return null;
  }

  public List<Android> visit(HilfskraftSoftware s) {
    Debug.println("ungueltige HilfskraftSoftware");
    return null;
  }

  public List<Android> visit(GesellschafterSoftware s) {
    Debug.println("ungueltige GesellschafterSoftware");
    return null;
  }

  public List<Android> visit(ObjektbewacherSoftware s) {
    Debug.println("ungueltige ObjektbewacherSoftware");
    return null;
  }

  public List<Android> visit(LeibwaechterSoftware s) {
    Debug.println("ungueltige LeibwaechterSoftware");
    return null;
  }

  public List<Android> visit(KaempferSoftware s) {
    Debug.println("ungueltige KaempferSoftware");
    return null;
  }

  public List<Android> visit(BauarbeiterSoftware s) {
    Debug.println("ungueltige BauarbeiterSoftware");
    return null;
  }

  public List<Android> visit(ServiceTechnikerSoftware s) {
    Debug.println("ungueltige ServiceTechnikerSoftware");
    return null;
  }

  public List<Android> visit(TransportarbeiterSoftware s) {
    Debug.println("ungueltige TransportarbeiterSoftware");
    return null;
  }

}
