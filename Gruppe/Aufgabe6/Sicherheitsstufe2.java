import java.util.List;

public class Sicherheitsstufe2 extends Sicherheitsstufe {
  public List<Android> accept(SicherheitsstufenInspector visitor) {
    return visitor.visit(this);
  }
}
