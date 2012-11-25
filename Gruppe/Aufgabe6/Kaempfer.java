import java.util.List;

public class Kaempfer extends Beschuetzer {
  public Kaempfer(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
