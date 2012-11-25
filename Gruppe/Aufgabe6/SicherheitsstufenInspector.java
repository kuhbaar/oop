import java.util.List;
import java.util.ArrayList;

public abstract class SicherheitsstufenInspector {
  public List<Android> visit(Sicherheitsstufe s) {
    return new ArrayList<Android>();
  }
}
