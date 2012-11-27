import java.util.List;
import java.util.ArrayList;

public class BedienerUpdateInspector extends Inspector {
  private List<Android> droids;

  public BedienerUpdateInspector(List<Android> droids) {
    this.droids = droids;
  }

  /* droids have to stay in the same catgeory */
  public List<Android> visit(Hilfskraft a) { return droids; }
  public List<Android> visit(Gesellschafter a) { return droids; }
}
