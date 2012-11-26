import java.util.List;

public class Sicherheitsstufe3 extends Sicherheitsstufe {
  public List<Android> accept(SicherheitsstufenInspector visitor) {
    return visitor.visit(this);
  }
}
