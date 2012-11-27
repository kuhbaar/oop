import java.util.List;
import java.util.ArrayList;

public class SchwerarbeiterUpdateInspector extends Inspector {
  private List<Android> droids;

  public SchwerarbeiterUpdateInspector(List<Android> droids) {
    this.droids = droids;
  }

  /* droids have to stay in the same catgeory */
  public List<Android> visit(Bauarbeiter a) { return droids; }
  public List<Android> visit(ServiceTechniker a) { return droids; }
  public List<Android> visit(Transportarbeiter a) { return droids; }
}
