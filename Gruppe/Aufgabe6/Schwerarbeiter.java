public abstract class Schwerarbeiter extends Android {
  public Schwerarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
