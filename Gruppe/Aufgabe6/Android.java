public abstract class Android {
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public boolean inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public boolean inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }
}
