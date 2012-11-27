import java.util.List;

public class RuleInspector extends Inspector {
  private List<Android> droids;

  public RuleInspector(List<Android> droids) {
    this.droids = droids;
  }

  public List<Android> visit(Android a) {
    throw new RuntimeException("shouldn't happen");
  }

  public List<Android> visit(Hilfskraft a) {
    this.droids = a.inspectSkin(new BedienerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new HilfskraftSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe12SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));
    return this.droids;
  }

  public List<Android> visit(Gesellschafter a) {
    this.droids = a.inspectSkin(new BedienerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new GesellschafterSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe1SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }

  public List<Android> visit(Bauarbeiter a) {
    this.droids = a.inspectSkin(new SchwerarbeiterSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new BauarbeiterSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe34SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));
    return this.droids;
  }

  public List<Android> visit(ServiceTechniker a) {
    this.droids = a.inspectSkin(new SchwerarbeiterSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new ServiceTechnikerSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe34SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }

  public List<Android> visit(Transportarbeiter a) {
    this.droids = a.inspectSkin(new SchwerarbeiterSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new TransportarbeiterSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe34SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }

  public List<Android> visit(Objektbewacher a) {
    this.droids = a.inspectSkin(new BeschuetzerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new ObjektbewacherSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe4SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }

  public List<Android> visit(Leibwaechter a) {
    this.droids = a.inspectSkin(new BeschuetzerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new LeibwaechterSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe4SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }

  public List<Android> visit(Kaempfer a) {
    this.droids = a.inspectSkin(new BeschuetzerSkinInspector(this.droids));
    this.droids = a.inspectSoftware(new KaempferSoftwareInspector(this.droids));
    this.droids = a.inspectSecurity(new Stufe5SoftwareSicherheitsInspector(this.droids));
    this.droids = a.inspectSecurity(new LeistungsInspector(this.droids, a.getPower()));

    return this.droids;
  }
}
