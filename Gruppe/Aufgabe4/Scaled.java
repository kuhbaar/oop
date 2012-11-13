import java.util.List;
import java.util.ArrayList;

public class Scaled<P extends Pict> implements Pict {
  private final List<List<P>> xss;
  private final BoxUtility<P> utility = new BoxUtility<P>();
  private FreeBox box;

  /* erstellt eine Box aus N*M objekten */
  public Scaled(List<List<P>> xss) {
    this.xss = new ArrayList<List<P>>(xss);
    scale(1.0);
  }

  /* verwandelt die Box in einen String. Dabei wird jedes Objekt durch seinen
     toString() Wert ersetzt. Zuerst wird es dazu mit dem Skalierungsfaktor skaliert,
     dann werden kleinere Strings mit Leerzeichen auf die Größe des größten 
     Strings aufgefüllt (in beiden Dimensionen). Anschließend wird alles aneinander
     gehängt. */
  public String toString() {
    return this.box.toString();
  }

  /* setzt die Skalierung zwischen 0.1 und 10.0 */
  public void scale(double factor) {
    for(List<P> xs : xss)
      for(P x : xs)
        x.scale(factor);

    final List<Integer> dims = utility.getMaxDimensions(xss);
    int max_width = dims.get(0);
    int max_height = dims.get(1);

    this.box = new FreeBox(utility.stringify(xss, max_width, max_height));
  }

}
