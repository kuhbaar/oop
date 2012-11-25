public class BeschuetzerSkinInspector implements SkinInspector {
  public boolean visit(Skin s) {
    System.out.println("Skin");
    return true;
  }
  public boolean visit(HochfesterSkin s) {
    System.out.println("HochfesterSkin");
    return true;
  }
}
