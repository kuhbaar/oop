import java.util.List;
import java.util.ArrayList;

public class Repeated<P> implements Pict {
  private final FreeBox box;

  /* erstellt eine Box mit dem toString() Wert der Objekte als Inhalt. Kleinere
     Strings werden dabei mit Leerzeichen auf die Größe des größten Strings auf-
     gefüllt (in beiden Dimensionen) */
  public Repeated(List<List<P>> xss) {
    final BoxUtility<P> utility = new BoxUtility<P>();

    final List<Integer> dims = utility.getMaxDimensions(xss);
    int max_width = dims.get(0);
    int max_height = dims.get(1);

    this.box = new FreeBox(utility.stringify(xss, max_width, max_height));
  }

  /* verwandelt die Box skaliert mit dem gesetzten Faktor in eine Zeichenkette.
     Ist der Faktor < 1, werden Teile des Texts weggelassen (rechte und untere 
     Rand), ist er größer als 1 wird der Text entsprechend wiederholt */
  public String toString() {
    return this.box.toString();
  }

  /* setzt die Skalierung zwischen 0.1 und 10.0 */
  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.box.scale(factor);
  }
}