/* auto-generated - change in class_generator.py */
import java.util.List;

public abstract class Schwerarbeiter extends Android {
  public Schwerarbeiter(String n, Skin s, Software sw, List<Actor> actors) {
    super(n, s, sw, actors);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
