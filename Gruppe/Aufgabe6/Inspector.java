import java.util.List;

public class Inspector {
  private List<Android> droids;

  public Inspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Android a) {
    System.out.println("Android");
    return droids;
  }

  public List<Android> visit(Kaempfer a) {
    System.out.println("Kaempfer");
    this.droids = a.inspectSkin(new BeschuetzerSkinInspector(droids));


    return this.droids;
  }
}
