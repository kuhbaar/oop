public class Box implements Pict {
  protected final int width;
  protected final int height;
  private final char border;
  private final char body;

  private double scale;

  public Box(int width, int height, char border, char body) {
    this.width = width;
    this.height = height;
    this.border = border;
    this.body = body;
    this.scale = 1.0;
  }
  
  public String toString() {
    int scaledHeight = (int) Math.ceil(height * scale);
    int scaledWidth = (int) Math.ceil(width * scale);

    if(scaledHeight == 0 && scaledWidth == 0) return "";
    if(scaledHeight == 1) return borderLine(scaledWidth);
    if(scaledHeight == 2) 
      return borderLine(scaledWidth) + "\n" + borderLine(scaledWidth);

    String out = borderLine(scaledWidth);
    for(int i = 0; i < scaledHeight - 2; i++)
      out += "\n" + bodyLine(scaledWidth);

    return out + "\n" + borderLine(scaledWidth);
  }

  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.scale = factor;
  }

  private String borderLine(int w) {
    String out = "";
    for(int i = 0; i < w; i++) 
      out += border;
    return out;
  }

  private String bodyLine(int w) {
    if(1 == w) return "" + border;
    else if(2 == w) return "" + border + border;

    String out = "" + border;
    for(int i = 0; i < w - 2; i++) 
      out += body;

    return out + border;
  }
}