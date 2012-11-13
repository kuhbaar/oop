public class ClearBox extends Box {

  /* erstellt eine Box mit konstanter Höhe und Breite, sowie unveränderlichen 
     Zeichen für Rand und Inhalt (die Zeichen sind fix auf '*'' und  ' ' gesetzt) */
  public ClearBox(int width, int height) {
    super(width, height, '*', ' ');
  }

  /* berechnet das Seitenverhältnis; kann sich nie ändern da Höhe und Breite ja
     konstant sind. */
  public double aspectRatio() {
    return 1.0 * width / height;
  }
}