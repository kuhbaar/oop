/* auto-generated - change in class_generator.py */
import java.util.List;

public class Stufe1SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe1SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe1 s) { return droids; }
}
