import java.util.List;

public class HochfesterSkin extends Skin {
  public List<Android> accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
