import java.util.List;

public abstract class Skin {
  public List<Android> accept(SkinInspector visitor) {
    return visitor.visit(this);
  }
}
