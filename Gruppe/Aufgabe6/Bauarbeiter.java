/* auto-generated - change in class_generator.py */
import java.util.List;

public class Bauarbeiter extends Schwerarbeiter {
  public Bauarbeiter(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
