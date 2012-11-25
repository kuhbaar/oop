public abstract class SoftwareInspector {
  public boolean visit(Software s) { return false; }
  public boolean visit(HilskraftSoftware s) { return false; }
  public boolean visit(GesellschafterSoftware s) { return false; }
  public boolean visit(ObjektbewacherSoftware s) { return false; }
  public boolean visit(LeibwaechterSoftware s) { return false; }
  public boolean visit(KaempferSoftware s) { return false; }
  public boolean visit(BauarbeiterSoftware s) { return false; }
  public boolean visit(ServiceTechnikerSoftware s) { return false; }
  public boolean visit(TransportarbeiterSoftware s) { return false; }
}
