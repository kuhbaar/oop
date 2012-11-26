import java.util.List;

public abstract class Software {
  private final String serial;
  private final Sicherheitsstufe stufe;

  public Software(String serial, Sicherheitsstufe stufe) {
    this.serial = serial;
    this.stufe = stufe;
  }

  public Sicherheitsstufe getSecurity() {
    return this.stufe;
  }

  public List<Android> accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }

  public List<Android> inspectSecurity(SicherheitsstufenInspector inspector) {
    return this.stufe.accept(inspector);
  }
}
