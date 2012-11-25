import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class AndroidList {
  private final ArrayList<Android> droids;

  public AndroidList() {
    this.droids = new ArrayList<Android>();
  }

 /* Die Methode find liefert einen String mit der Beschreibung aller Ausstattungsdetails
    des Androiden mit der als Parameter gegebenen Seriennummer zurück (oder null
    falls kein Androide mit dieser Seriennummer existiert). */
  public String find(String sn) {
    HashMap<String, Android> m = new HashMap<String, Android>();
    for(Android a : this.droids)
      m.put(a.getSerial(), a);

    Android a = m.get(sn);
    return a == null ? null : a.toString();
  }

  /* Die Methode iterator erzeugt einen Iterator über den ausgelieferten Androiden
    in der Reihenfolge der ersten Auslieferung (das ist die Reihenfolge des
    Einfügens neuer Androiden). */
  public Iterator<Android> iterator() {
    return this.droids.iterator();
  }

  /* true wenn insert erfolgreich war, sonst false */
  public boolean insert(Android a) {
    List<Android> aList = a.accept(new Inspector(this.droids));
    aList.add(a);
    return this.droids == aList;
/* Die Methode insert fügt einen Androiden mit eindeutiger Seriennummer und allen Ausstattungsdetails in die Liste ein und prüft die Bedingungen der Androide-Verordnung. Sind die Bedingungen nicht erfüllt, bleibt die Liste unverändert, und ein entsprechender Fehlercode wird zurückgegeben. Kommt ein Androide mit derselben Seriennummer bereits in der Liste vor, so handelt es sich um eine Änderung, sonst um die Auslieferung eines neuen Androiden. Als Ausstattungsdetails bekommt jeder Android ein Sensoren-Aktoren-Kit, eine Skin und eine Software mit. */
  }
}
