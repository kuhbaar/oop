public class HochfesterSkin extends Skin {
  public boolean accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
