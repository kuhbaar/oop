import java.util.List;
import java.util.ArrayList;

public class BeschuetzerUpdateInspector extends Inspector {
  private List<Android> droids;

  public BeschuetzerUpdateInspector(List<Android> droids) {
    this.droids = droids;
  }

  /* droids have to stay in the same catgeory */
  public List<Android> visit(Objektbewacher a) { return droids; }
  public List<Android> visit(Leibwaechter a) { return droids; }
  public List<Android> visit(Kaempfer a) { return droids; }
}
