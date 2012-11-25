import java.util.List;

public class Gesellschafter extends Bediener {
  public Gesellschafter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
