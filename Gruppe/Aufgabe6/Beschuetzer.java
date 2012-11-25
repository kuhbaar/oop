import java.util.List;

public abstract class Beschuetzer extends Android {
  public Beschuetzer(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
