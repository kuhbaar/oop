import java.util.List;

public class Stufe12SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe12SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe1 s) { return droids; }
  public List<Android> visit(Sicherheitsstufe2 s) { return droids; }
}
