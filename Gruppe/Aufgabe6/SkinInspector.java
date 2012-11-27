import java.util.List;
import java.util.ArrayList;

public abstract class SkinInspector {
  protected final List<Android> droids;

  public SkinInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Skin s) { 
    System.err.println("ungueltiger Skin"); 
    return null; 
  }

  public List<Android> visit(HochfesterSkin s) { 
    System.err.println("ungueltiger HochfesterSkin"); 
    return null; 
  }

  public List<Android> visit(BeruehrungsSensitiverSkin s) { 
    System.err.println("ungueltiger BeruehrungsSensitiverSkin"); 
    return null; 
  }

  public List<Android> visit(GepanzerterSkin s) { 
    System.err.println("ungueltiger GepanzerterSkin"); 
    return null; 
  }
}
