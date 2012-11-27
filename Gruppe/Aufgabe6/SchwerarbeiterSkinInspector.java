import java.util.List;

public class SchwerarbeiterSkinInspector extends SkinInspector {
  public SchwerarbeiterSkinInspector(List<Android> droids) {
    super(droids);
  }

  /* Schwerarbeiter koennen den beruehrungssensitiven und den hochfesten Skin haben */
  public List<Android> visit(HochfesterSkin s) { return droids; }
  public List<Android> visit(BeruehrungsSensitiverSkin s) { return droids; }
}
