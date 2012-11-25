import java.util.List;
import java.util.ArrayList;

public abstract class SoftwareInspector {
  public List<Android> visit(Software s) { return new ArrayList<Android>(); }
  public List<Android> visit(HilfskraftSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(GesellschafterSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(ObjektbewacherSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(LeibwaechterSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(KaempferSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(BauarbeiterSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(ServiceTechnikerSoftware s) { return new ArrayList<Android>(); }
  public List<Android> visit(TransportarbeiterSoftware s) { return new ArrayList<Android>(); }
}
