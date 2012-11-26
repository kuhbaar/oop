import java.util.List;

public class BeschuetzerSkinInspector extends SkinInspector {
  public BeschuetzerSkinInspector(List<Android> droids) {
    super(droids);
  }

  /* Beschuetzer koennen jeden Skin haben */
  public List<Android> visit(Skin s) { return droids; }
  public List<Android> visit(HochfesterSkin s) { return droids; }
  public List<Android> visit(BeruehrungsSensitiverSkin s) { return droids; }
  public List<Android> visit(GepanzerterSkin s) { return droids; }
}
