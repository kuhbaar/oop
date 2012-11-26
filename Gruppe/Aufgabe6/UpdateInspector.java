import java.util.List;

public class UpdateInspector extends Inspector {
  private List<Android> droids;
  private Android newAndroid;

  public UpdateInspector(List<Android> droids, Android newAndroid) {
    this.droids = droids;
    this.newAndroid = newAndroid;
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
    /* general type has to be the same (= subclass of Beschuetzer),
       security level of software is not allowed to change */
    System.out.println("Kaempfer");
    this.droids = newAndroid.accept(new BeschuetzerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, newAndroid.getSecurity()));

    return this.droids;
  }
}
