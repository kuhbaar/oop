import java.util.List;

public class ObjektbewacherSoftwareInspector extends SoftwareInspector {
  public ObjektbewacherSoftwareInspector(List<Android> droids) {
    super(droids);
  }

  @Override public List<Android> visit(ObjektbewacherSoftware s) { return droids; }
}
