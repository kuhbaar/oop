import java.util.List;

public abstract class Sicherheitsstufe {
  public List<Android> accept(SicherheitsstufenInspector visitor) {
    return visitor.visit(this);
  }
}
