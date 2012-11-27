import java.util.List;
import java.util.ArrayList;

public abstract class Inspector {
  public List<Android> visit(Android a) { 
    assert(false);    /* should never be reached */
    return null;
  }

  public List<Android> visit(Hilfskraft a) { 
    System.err.println("ungueltige Hilfskraft");
    return null; 
  }

  public List<Android> visit(Gesellschafter a) { 
    System.err.println("ungueltige Gesellschafter");
    return null; 
  }

  public List<Android> visit(Bauarbeiter a) { 
    System.err.println("ungueltige Bauarbeiter");
    return null; 
  }

  public List<Android> visit(ServiceTechniker a) { 
    System.err.println("ungueltige ServiceTechniker");
    return null; 
  }

  public List<Android> visit(Transportarbeiter a) { 
    System.err.println("ungueltige Transportarbeiter");
    return null; 
  }

  public List<Android> visit(Objektbewacher a) { 
    System.err.println("ungueltige Objektbewacher");
    return null; 
  }

  public List<Android> visit(Leibwaechter a) { 
    System.err.println("ungueltige Leibwaechter");
    return null; 
  }

  public List<Android> visit(Kaempfer a) { 
    System.err.println("ungueltige Kaempfer");
    return null; 
  }

}
