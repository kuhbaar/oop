/* auto-generated - change in class_generator.py */
import java.util.List;

public class Stufe3SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe3SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe3 s) { return droids; }
}
