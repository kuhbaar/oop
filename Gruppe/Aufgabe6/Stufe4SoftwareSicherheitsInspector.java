/* auto-generated - change in class_generator.py */
import java.util.List;

public class Stufe4SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe4SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe4 s) { return droids; }
}
