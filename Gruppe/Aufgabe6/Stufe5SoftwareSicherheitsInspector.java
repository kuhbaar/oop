import java.util.List;

public class Stufe5SoftwareSicherheitsInspector extends SicherheitsstufenInspector {
  public Stufe5SoftwareSicherheitsInspector(List<Android> droids) {
    super(droids);
  }

  public List<Android> visit(Sicherheitsstufe5 s) { return droids; }
}
