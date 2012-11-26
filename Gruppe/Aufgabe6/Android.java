import java.util.List;

public abstract class Android {
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public String getSerial() {
    return seriennr;
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public List<Android> inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public List<Android> inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }

  public List<Android> inspectSecurity(SicherheitsstufenInspector visitor) {
    return sw.inspectSecurity(visitor);
  }
}
