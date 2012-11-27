import java.util.List;
import java.util.ArrayList;

public abstract class SoftwareInspector {
  protected final List<Android> droids;

  public SoftwareInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Software s) { return null; }
  public List<Android> visit(HilfskraftSoftware s) { return null; }
  public List<Android> visit(GesellschafterSoftware s) { return null; }
  public List<Android> visit(ObjektbewacherSoftware s) { return null; }
  public List<Android> visit(LeibwaechterSoftware s) { return null; }
  public List<Android> visit(KaempferSoftware s) { return null; }
  public List<Android> visit(BauarbeiterSoftware s) { return null; }
  public List<Android> visit(ServiceTechnikerSoftware s) { return null; }
  public List<Android> visit(TransportarbeiterSoftware s) { return null; }
}
