public class Objektbewacher extends Beschuetzer {
  public Objektbewacher(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
