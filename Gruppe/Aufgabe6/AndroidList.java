import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class AndroidList {
  private final ArrayList<Android> droids;

  public AndroidList() {
    this.droids = new ArrayList<Android>();
  }

  /* null if Android doesn't exist */
  private Android get(String sn) {
    HashMap<String, Android> m = new HashMap<String, Android>();
    for(Android a : this.droids)
      m.put(a.getSerial(), a);

    return m.get(sn);
  }

 /* Die Methode find liefert einen String mit der Beschreibung aller Ausstattungsdetails
    des Androiden mit der als Parameter gegebenen Seriennummer zurück (oder null
    falls kein Androide mit dieser Seriennummer existiert). */
  public String find(String sn) {
    Android a = this.get(sn);
    return a == null ? null : a.toString();
  }

  /* Die Methode iterator erzeugt einen Iterator über den ausgelieferten Androiden
    in der Reihenfolge der ersten Auslieferung (das ist die Reihenfolge des
    Einfügens neuer Androiden). */
  public Iterator<Android> iterator() {
    return this.droids.iterator();
  }
  /* Die Methode insert fügt einen Androiden mit eindeutiger Seriennummer und
    allen Ausstattungsdetails in die Liste ein und prüft die Bedingungen der
    Androide-Verordnung. Sind die Bedingungen nicht erfüllt, bleibt die Liste
    unverändert, und ein entsprechender Fehlercode wird zurückgegeben. Kommt
    ein Androide mit derselben Seriennummer bereits in der Liste vor, so handelt
    es sich um eine Änderung, sonst um die Auslieferung eines neuen Androiden.
    Als Ausstattungsdetails bekommt jeder Android ein Sensoren-Aktoren-Kit,
    eine Skin und eine Software mit. */
  /* true wenn insert erfolgreich war, sonst false */
  public boolean insert(Android a) {
    Android old = this.get(a.getSerial());

    if(old == null) {
      /* we don't have this android yet - check rules, then add it */
      List<Android> aList = a.accept(new RuleInspector(this.droids));
      aList.add(a);
      return this.droids == aList;
    } else {
      /* update - first, enforce update rules, then the normal ones */
      List<Android> aList = a.accept(new UpdateInspector(this.droids, a));
      aList = a.accept(new RuleInspector(this.droids));
      aList.add(a);
      return this.droids == aList;
    }
  }
}
