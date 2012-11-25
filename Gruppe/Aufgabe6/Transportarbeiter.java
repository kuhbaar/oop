public class Transportarbeiter extends Schwerarbeiter {
  public Transportarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
