import java.util.List;
import java.util.ArrayList;

public abstract class Inspector {
  public List<Android> visit(Android a) { return null; }
  public List<Android> visit(Hilfskraft a) { return null; }
  public List<Android> visit(Gesellschafter a) { return null; }
  public List<Android> visit(Bauarbeiter a) { return null; }
  public List<Android> visit(ServiceTechniker a) { return null; }
  public List<Android> visit(Transportarbeiter a) { return null; }
  public List<Android> visit(Objektbewacher a) { return null; }
  public List<Android> visit(Leibwaechter a) { return null; }
  public List<Android> visit(Kaempfer a) { return null; }
}
