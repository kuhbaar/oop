public class Transportarbeiter extends Schwerarbeiter {
  public Transportarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
