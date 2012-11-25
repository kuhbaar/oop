public class BeruehungsSensitiverSkin extends Skin {
  public boolean accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
