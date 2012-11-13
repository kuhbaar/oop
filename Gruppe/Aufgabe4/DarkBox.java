public class DarkBox implements Pict {
  private final int width; //unveraenderlich
  private final int height; //unveraenderlich
  
  private double scale; //stets zw. 0.1 und 10.0
  private Box b;

  /* erstellt eine Box mit konstanter Höhe und Breite, das Zeichen für den Inhalt
     (Rand gibt es keinen) ist aber veränderlich! */
  public DarkBox(int width, int height, char c) {
    this.b = new Box(width, height, c, c);
    this.width = width;
    this.height = height;
    this.scale = 1.0;
  }
  
  /* verwandelt die Box skaliert mit dem gesetzten Faktor in eine Zeichenkette */
  public String toString() {
    return b.toString();
  }

  /* setzt die Skalierung zwischen 0.1 und 10.0 */
  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.scale = factor;
    b.scale(factor);
  }

  /* setzt das Zeichen für den Inhalt */
  public void setChar(char c) {
    this.b = new Box(this.width, this.height, c, c);
    this.b.scale(this.scale);
  }
}