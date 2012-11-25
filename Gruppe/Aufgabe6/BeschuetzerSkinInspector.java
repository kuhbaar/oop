import java.util.List;

public class BeschuetzerSkinInspector extends SkinInspector {
  public BeschuetzerSkinInspector(List<Android> droids) {
    super(droids);
  }

  public List<Android> visit(Skin s) {
    System.out.println("Skin");
    return droids;
  }
  public List<Android> visit(HochfesterSkin s) {
    System.out.println("HochfesterSkin");
    return droids;
  }
}
