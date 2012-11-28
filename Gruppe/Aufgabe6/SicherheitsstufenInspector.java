import java.util.List;

public abstract class SicherheitsstufenInspector {
  public List<Android> visit(Sicherheitsstufe s) {
    Debug.println("ungueltige Sicherheitsstufe");
    return null;
  }
  public List<Android> visit(Sicherheitsstufe1 s) {
    Debug.println("ungueltige Sicherheitsstufe1");
    return null;
  }
  public List<Android> visit(Sicherheitsstufe2 s) {
    Debug.println("ungueltige Sicherheitsstufe2");
    return null;
  }
  public List<Android> visit(Sicherheitsstufe3 s) {
    Debug.println("ungueltige Sicherheitsstufe3");
    return null;
  }
  public List<Android> visit(Sicherheitsstufe4 s) {
    Debug.println("ungueltige Sicherheitsstufe4");
    return null;
  }
  public List<Android> visit(Sicherheitsstufe5 s) {
    Debug.println("ungueltige Sicherheitsstufe5");
    return null;
  }
}
