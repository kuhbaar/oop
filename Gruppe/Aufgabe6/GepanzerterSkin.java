public class GepanzerterSkin extends Skin {
  public boolean accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
