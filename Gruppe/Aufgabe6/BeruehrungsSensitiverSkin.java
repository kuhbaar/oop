import java.util.List;

public class BeruehrungsSensitiverSkin extends Skin {
  public List<Android> accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
