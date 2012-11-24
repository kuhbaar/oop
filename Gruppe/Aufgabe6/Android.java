public abstract class Android{
  private final String seriennr;
  private Skin s;
  private Software sw;

  public Android(String n, Skin s, Software sw) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
  }

  public void accept(Inspector visitor) {
    visitor.visit(this); /* this needs to be implemented in each subclass
      the only reason I've provided a default implementation here is because
      I'm to lazy to add it in all classes right now */
  }

  public boolean inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }
}
