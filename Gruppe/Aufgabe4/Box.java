public class Box implements Pict {
  protected final int width;
  protected final int height;
  private final char border;
  private final char body;

  private final BoxPrinter printer;

  private double scale;

  /* erstellt eine Box mit konstanter Höhe und Breite, sowie unveränderlichen 
     Zeichen für Rand und Inhalt */
  public Box(int width, int height, char border, char body) {
    this.width = width;
    this.height = height;
    this.border = border;
    this.body = body;
    this.scale = 1.0;

    this.printer = new BoxPrinter();
  }
  
  /* verwandelt die Box skaliert mit dem gesetzten Faktor in eine Zeichenkette */
  public String toString() {
    int scaledHeight = (int) Math.ceil(height * scale);
    int scaledWidth = (int) Math.ceil(width * scale);

    return printer.print(scaledWidth, scaledHeight, border, body);
  }

  /* setzt die Skalierung zwischen 0.1 und 10.0 */
  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.scale = factor;
  }

  
}