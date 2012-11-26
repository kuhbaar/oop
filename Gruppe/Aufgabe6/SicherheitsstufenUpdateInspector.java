import java.util.List;
import java.util.ArrayList;

public class SicherheitsstufenUpdateInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;
  private final Sicherheitsstufe alteSicherheit;

  public SicherheitsstufenUpdateInspector(List<Android> droids, Sicherheitsstufe alteSicherheit) {
    this.droids = droids;
    this.alteSicherheit = alteSicherheit;
  }

  public List<Android> visit(Sicherheitsstufe1 s) {
    return alteSicherheit.accept(new Stufe1SoftwareSicherheitsInspector(droids));
  }

  public List<Android> visit(Sicherheitsstufe2 s) {
    return alteSicherheit.accept(new Stufe2SoftwareSicherheitsInspector(droids));
  }

  public List<Android> visit(Sicherheitsstufe3 s) {
    return alteSicherheit.accept(new Stufe3SoftwareSicherheitsInspector(droids));
  }

  public List<Android> visit(Sicherheitsstufe4 s) {
    return alteSicherheit.accept(new Stufe4SoftwareSicherheitsInspector(droids));
  }

  public List<Android> visit(Sicherheitsstufe5 s) {
    return alteSicherheit.accept(new Stufe5SoftwareSicherheitsInspector(droids));
  }
}
