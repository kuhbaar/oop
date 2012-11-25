import java.util.List;

public class Sicherheitsstufe1 extends Sicherheitsstufe {
  public List<Android> accept(SicherheitsstufenInspector visitor) {
    return visitor.visit(this);
  }
}
