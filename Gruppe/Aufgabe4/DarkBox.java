public class DarkBox implements Pict {
  private final int width;
  private final int height;
  
  private double scale;
  private Box b;

  public DarkBox(int width, int height, char c) {
    this.b = new Box(width, height, c, c);
    this.width = width;
    this.height = height;
    this.scale = 1.0;
  }
  
  public String toString() {
    return b.toString();
  }

  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.scale = factor;
    b.scale(factor);
  }

  public void setChar(char c) {
    this.b = new Box(this.width, this.height, c, c);
    this.b.scale(this.scale);
  }
}