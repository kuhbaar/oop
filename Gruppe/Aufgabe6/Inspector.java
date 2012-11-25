public class Inspector {
  public boolean visit(Android a) {
    System.out.println("Android");
    return true;
  }

  public boolean visit(Kaempfer a) {
    System.out.println("Kaempfer");
    a.inspectSkin(new BeschuetzerSkinInspector());
    return true;
  }
}
