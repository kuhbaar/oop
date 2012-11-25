public class Gesellschafter extends Bediener {
  public Gesellschafter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public void accept(Inspector visitor) {
    visitor.visit(this);
  }
}
