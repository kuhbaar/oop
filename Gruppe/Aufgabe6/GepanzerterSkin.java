import java.util.List;

public class GepanzerterSkin extends Skin {
  public List<Android> accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
