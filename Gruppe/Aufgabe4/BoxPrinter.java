public class BoxPrinter {
  public String print(int width, int height, char border, char body) {
    if(height == 0 && width == 0) return "";
    if(height == 1) return borderLine(width, border);
    if(height == 2) 
      return borderLine(width, border) + "\n" + borderLine(width, border);

    String out = borderLine(width, border);
    for(int i = 0; i < height - 2; i++)
      out += "\n" + bodyLine(width, border, body);

    return out + "\n" + borderLine(width, border);
  }

  private String borderLine(int w, char border) {
    String out = "";
    for(int i = 0; i < w; i++) 
      out += border;
    return out;
  }

  private String bodyLine(int w, char border, char body) {
    if(1 == w) return "" + border;
    else if(2 == w) return "" + border + border;

    String out = "" + border;
    for(int i = 0; i < w - 2; i++) 
      out += body;

    return out + border;
  }
}