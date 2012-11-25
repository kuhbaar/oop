public class Leibwaechter extends Beschuetzer {
  public Leibwaechter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
