public class Hilfskraft extends Bediener {
  public Hilfskraft(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
