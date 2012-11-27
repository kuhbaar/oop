import java.util.List;
import java.util.ArrayList;

public abstract class SkinInspector {
  protected final List<Android> droids;

  public SkinInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Skin s) { return null; }
  public List<Android> visit(HochfesterSkin s) { return null; }
  public List<Android> visit(BeruehrungsSensitiverSkin s) { return null; }
  public List<Android> visit(GepanzerterSkin s) { return null; }
}
