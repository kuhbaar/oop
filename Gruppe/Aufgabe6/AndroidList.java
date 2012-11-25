import java.util.ArrayList;

Konkret soll eine Liste aller ausgelieferten Androiden geführt werden, die Folgendes erlaubt:

Die Methode find liefert einen String mit der Beschreibung aller Ausstattungsdetails des Androiden mit der als Parameter gegebenen Seriennummer zurück (oder null falls kein Androide mit dieser Seriennummer existiert).
Die Methode iterator erzeugt einen Iterator über den ausgelieferten Androiden in der Reihenfolge der ersten Auslieferung (das ist die Reihenfolge des Einfügens neuer Androiden).


public class AndroidList {
  private final ArrayList<Android> droids;

  public AndroidList() {
    this.droids = new ArrayList<Android>();
  }

  public insert(Android a) {
    a.accept(new Inspector(droids));
/* Die Methode insert fügt einen Androiden mit eindeutiger Seriennummer und allen Ausstattungsdetails in die Liste ein und prüft die Bedingungen der Androide-Verordnung. Sind die Bedingungen nicht erfüllt, bleibt die Liste unverändert, und ein entsprechender Fehlercode wird zurückgegeben. Kommt ein Androide mit derselben Seriennummer bereits in der Liste vor, so handelt es sich um eine Änderung, sonst um die Auslieferung eines neuen Androiden. Als Ausstattungsdetails bekommt jeder Android ein Sensoren-Aktoren-Kit, eine Skin und eine Software mit. */
  }
}
