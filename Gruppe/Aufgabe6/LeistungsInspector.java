import java.util.List;

public class LeistungsInspector extends SicherheitsstufenInspector {
  private final List<Android> droids;
  private final int leistung;

  public LeistungsInspector(List<Android> droids, double leistung) {
    assert(leistung >= 0);
    this.droids = droids;
    this.leistung = Math.ceil(leistung);
  }

  public List<Android> visit(Sicherheitsstufe1 s) { return droids; }
  public List<Android> visit(Sicherheitsstufe2 s) { return droids; }
  public List<Android> visit(Sicherheitsstufe3 s) { 
    HashMap<Integer, List<Android>> m = new HashMap<Integer, List<Android>>();
    for(int i = 0; i < 5; i++)
      m.put(i, droids);

    List<Android> as = m.get(this.leistung);


    return as == null ? new ArrayList<Android>() : as;
  }
  public List<Android> visit(Sicherheitsstufe4 s) { return droids; }
  public List<Android> visit(Sicherheitsstufe5 s) { return droids; }
}