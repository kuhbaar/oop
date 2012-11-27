import java.util.List;

public class UpdateInspector extends Inspector {
  private List<Android> droids;
  private Android newAndroid;
  private Android oldAndroid;

  public UpdateInspector(List<Android> droids, Android newAndroid, Android oldAndroid) {
    this.droids = droids;
    this.newAndroid = newAndroid;
    this.oldAndroid = oldAndroid;
  }


  /* general type has to be the same (= subclass of Beschuetzer),
      security level of software is not allowed to change */

  public List<Android> visit(Android a) {
    assert(false);    /* should never be reached */
    return null;
  }

  public List<Android> visit(Hilfskraft a) {
    this.droids = newAndroid.accept(new BedienerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Gesellschafter a) {
    this.droids = newAndroid.accept(new BedienerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Bauarbeiter a) {
    this.droids = newAndroid.accept(new SchwerarbeiterUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(ServiceTechniker a) {
    this.droids = newAndroid.accept(new SchwerarbeiterUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Transportarbeiter a) {
    this.droids = newAndroid.accept(new SchwerarbeiterUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Objektbewacher a) {
    this.droids = newAndroid.accept(new BeschuetzerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Leibwaechter a) {
    this.droids = newAndroid.accept(new BeschuetzerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }

  public List<Android> visit(Kaempfer a) {
    this.droids = newAndroid.accept(new BeschuetzerUpdateInspector(this.droids));
    this.droids = newAndroid.inspectSecurity(
      new SicherheitsstufenUpdateInspector(this.droids, oldAndroid.getSecurity()));

    return this.droids;
  }
}
