/* auto-generated - change in class_generator.py */
import java.util.List;
import java.util.ArrayList;

public abstract class Android {
  private final String seriennr;
  private Skin s;
  private Software sw;
  private List<Actor> actors;

  public Android(String n, Skin s, Software sw, List<Actor> actors) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
    this.actors = new ArrayList<Actor>(actors);
  }

  public String getSerial() {
    return seriennr;
  }

  public double getPower() {
    double total = 0;
    for(Actor a : actors)
      total += a.getPower();
    return total;
  }

  public Sicherheitsstufe getSecurity() {
    return sw.getSecurity();
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public List<Android> inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public List<Android> inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }

  public List<Android> inspectSecurity(SicherheitsstufenInspector visitor) {
    return sw.inspectSecurity(visitor);
  }
}
