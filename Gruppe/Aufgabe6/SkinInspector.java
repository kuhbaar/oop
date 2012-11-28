import java.util.List;
import java.util.ArrayList;

public abstract class SkinInspector {
  protected final List<Android> droids;

  public SkinInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Skin s) {
    Debug.println("ungueltiger Skin");
    return null;
  }

  public List<Android> visit(HochfesterSkin s) {
    Debug.println("ungueltiger HochfesterSkin");
    return null;
  }

  public List<Android> visit(BeruehrungsSensitiverSkin s) {
    Debug.println("ungueltiger BeruehrungsSensitiverSkin");
    return null;
  }

  public List<Android> visit(GepanzerterSkin s) {
    Debug.println("ungueltiger GepanzerterSkin");
    return null;
  }
}
