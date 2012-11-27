import java.util.List;
import java.util.ArrayList;

public abstract class SoftwareInspector {
  protected final List<Android> droids;

  public SoftwareInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Software s) { 
    System.err.println("ungueltige Software");
    return null; 
  }

  public List<Android> visit(HilfskraftSoftware s) { 
    System.err.println("ungueltige HilfskraftSoftware");
    return null; 
  }

  public List<Android> visit(GesellschafterSoftware s) { 
    System.err.println("ungueltige GesellschafterSoftware");
    return null; 
  }

  public List<Android> visit(ObjektbewacherSoftware s) { 
    System.err.println("ungueltige ObjektbewacherSoftware");
    return null; 
  }

  public List<Android> visit(LeibwaechterSoftware s) { 
    System.err.println("ungueltige LeibwaechterSoftware");
    return null; 
  }

  public List<Android> visit(KaempferSoftware s) { 
    System.err.println("ungueltige KaempferSoftware");
    return null; 
  }

  public List<Android> visit(BauarbeiterSoftware s) { 
    System.err.println("ungueltige BauarbeiterSoftware");
    return null; 
  }

  public List<Android> visit(ServiceTechnikerSoftware s) { 
    System.err.println("ungueltige ServiceTechnikerSoftware");
    return null; 
  }

  public List<Android> visit(TransportarbeiterSoftware s) { 
    System.err.println("ungueltige TransportarbeiterSoftware");
    return null; 
  }

}
