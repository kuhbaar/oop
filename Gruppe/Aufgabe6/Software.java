public abstract class Software {
  private final String serial;
  private final int sicherheitsstufe;

  public Software(String serial, int sicherheitsstufe) {
    assert(sicherheitsstufe >= 1 && sicherheitsstufe <= 5);
    this.serial = serial;
    this.sicherheitsstufe = sicherheitsstufe;
  }

  public boolean accept(SoftwareInspector inspector) {
    return inspector.visit(this);
  }
}
