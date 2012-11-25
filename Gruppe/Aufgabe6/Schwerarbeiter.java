import java.util.List;

public abstract class Schwerarbeiter extends Android {
  public Schwerarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
