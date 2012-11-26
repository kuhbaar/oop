import java.util.List;
import java.util.ArrayList;

public abstract class Inspector {
  public List<Android> visit(Android a) { return new ArrayList<Android>(); }
  public List<Android> visit(Hilfskraft a) { return new ArrayList<Android>(); }
  public List<Android> visit(Gesellschafter a) { return new ArrayList<Android>(); }
  public List<Android> visit(Bauarbeiter a) { return new ArrayList<Android>(); }
  public List<Android> visit(ServiceTechniker a) { return new ArrayList<Android>(); }
  public List<Android> visit(Transportarbeiter a) { return new ArrayList<Android>(); }
  public List<Android> visit(Objektbewacher a) { return new ArrayList<Android>(); }
  public List<Android> visit(Leibwaechter a) { return new ArrayList<Android>(); }
  public List<Android> visit(Kaempfer a) { return new ArrayList<Android>(); }
}
