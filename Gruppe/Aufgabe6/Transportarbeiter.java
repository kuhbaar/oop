import java.util.List;

public class Transportarbeiter extends Schwerarbeiter {
  public Transportarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
