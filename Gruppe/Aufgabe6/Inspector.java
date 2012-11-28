import java.util.List;
import java.util.ArrayList;

public abstract class Inspector {
  public List<Android> visit(Android a) {
    assert(false);    /* should never be reached */
    return null;
  }

  public List<Android> visit(Hilfskraft a) {
    Debug.println("ungueltige Hilfskraft");
    return null;
  }

  public List<Android> visit(Gesellschafter a) {
    Debug.println("ungueltige Gesellschafter");
    return null;
  }

  public List<Android> visit(Bauarbeiter a) {
    Debug.println("ungueltige Bauarbeiter");
    return null;
  }

  public List<Android> visit(ServiceTechniker a) {
    Debug.println("ungueltige ServiceTechniker");
    return null;
  }

  public List<Android> visit(Transportarbeiter a) {
    Debug.println("ungueltige Transportarbeiter");
    return null;
  }

  public List<Android> visit(Objektbewacher a) {
    Debug.println("ungueltige Objektbewacher");
    return null;
  }

  public List<Android> visit(Leibwaechter a) {
    Debug.println("ungueltige Leibwaechter");
    return null;
  }

  public List<Android> visit(Kaempfer a) {
    Debug.println("ungueltige Kaempfer");
    return null;
  }

}
