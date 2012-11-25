public class ServiceTechniker extends Schwerarbeiter {
  public ServiceTechniker(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    visitor.visit(this);
  }
}
