public abstract class Beschuetzer extends Android {
  public Beschuetzer(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
