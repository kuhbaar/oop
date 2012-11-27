import java.util.List;

public abstract class SicherheitsstufenInspector {
  public List<Android> visit(Sicherheitsstufe s) { return null; }
  public List<Android> visit(Sicherheitsstufe1 s) { return null; }
  public List<Android> visit(Sicherheitsstufe2 s) { return null; }
  public List<Android> visit(Sicherheitsstufe3 s) { return null; }
  public List<Android> visit(Sicherheitsstufe4 s) { return null; }
  public List<Android> visit(Sicherheitsstufe5 s) { return null; }
}
