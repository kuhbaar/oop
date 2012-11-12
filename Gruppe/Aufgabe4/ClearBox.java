public class ClearBox extends Box {
  public ClearBox(int width, int height) {
    super(width, height, '*', ' ');
  }

  public double aspectRatio() {
    return 1.0 * width / height;
  }
}