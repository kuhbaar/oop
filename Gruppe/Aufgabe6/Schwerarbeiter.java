public class Schwerarbeiter extends Android {
  public Schwerarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
