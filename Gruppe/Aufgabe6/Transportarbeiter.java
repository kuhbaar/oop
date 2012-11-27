/* auto-generated - change in class_generator.py */
import java.util.List;

public class Transportarbeiter extends Schwerarbeiter {
  public Transportarbeiter(String n, Skin s, Software sw, List<Actor> actors) {
    super(n, s, sw, actors);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
