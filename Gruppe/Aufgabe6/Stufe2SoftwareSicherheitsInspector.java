/* auto-generated - change in class_generator.py */
import java.util.List;

public class Stufe2SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe2SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe2 s) { return droids; }
}
