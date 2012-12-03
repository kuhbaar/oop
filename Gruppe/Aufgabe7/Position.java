public class Position {
  /* setter und getter sind vollkommen ueberfluessig, da die werte sowieso
      unveraenderlich sind (final).  */
  public final int w;
  public final int h;

  public Position(int w, int h) {
    this.w = w;
    this.h = h;
  }
}
