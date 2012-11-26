import java.util.List;

public class Stufe5SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;

  public Stufe5SoftwareSicherheitsInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Sicherheitsstufe5 s) { return droids; }
}
