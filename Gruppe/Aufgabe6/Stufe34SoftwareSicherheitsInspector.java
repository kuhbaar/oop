import java.util.List;

public class Stufe34SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe34SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe3 s) { return droids; }
  public List<Android> visit(Sicherheitsstufe4 s) { return droids; }
}
