public class Box implements Pict {
  private final int width;
  private final int height;
  private final char border;
  private final char body;


  public Box(int width, int height, char border, char body) {
    this->width = width;
    this->height = height;
    this->border = border;
    this->body = body;
  }
  
  public String toString() {
    throw new RuntimeException("not implemented");
  }

  public void scale(double factor) {
    throw new RuntimeException("not implemented");
  }
}