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

  public List<Android> visit(Hilfskraft a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Gesellschafter a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Bauarbeiter a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(ServiceTechniker a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Transportarbeiter a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Objektbewacher a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Leibwaechter a) {
    throw new RuntimeException("not implemented");
  }

  public List<Android> visit(Kaempfer a) {
    System.out.println("Kaempfer");
    this.droids = a.inspectSkin(new BeschuetzerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new KaempferSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe5SoftwareSicherheitsInspector(this.droids));

    return this.droids;
  }
}
