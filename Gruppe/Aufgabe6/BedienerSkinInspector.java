import java.util.List;

public class BedienerSkinInspector extends SkinInspector {
  public BedienerSkinInspector(List<Android> droids) {
    super(droids);
  }

  /* Bediener koennen den beruehrungssensitiven Skin haben */
  public List<Android> visit(BeruehrungsSensitiverSkin s) { return droids; }
}
