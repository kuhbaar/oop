import java.util.List;
import java.util.ArrayList;

public abstract class SicherheitsstufenInspector {
  public List<Android> visit(Sicherheitsstufe s) { return new ArrayList<Android>(); }
  public List<Android> visit(Sicherheitsstufe1 s) { return new ArrayList<Android>(); }
  public List<Android> visit(Sicherheitsstufe2 s) { return new ArrayList<Android>(); }
  public List<Android> visit(Sicherheitsstufe3 s) { return new ArrayList<Android>(); }
  public List<Android> visit(Sicherheitsstufe4 s) { return new ArrayList<Android>(); }
  public List<Android> visit(Sicherheitsstufe5 s) { return new ArrayList<Android>(); }
}
