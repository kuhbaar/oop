import java.util.List;
import java.util.ArrayList;

public class Repeated<P> implements Pict {
  private final FreeBox box;

  public Repeated(List<List<P>> xss) {
    final BoxUtility<P> utility = new BoxUtility<P>();

    final List<Integer> dims = utility.getMaxDimensions(xss);
    int max_width = dims.get(0);
    int max_height = dims.get(1);

    this.box = new FreeBox(utility.stringify(xss, max_width, max_height));
  }

  public String toString() {
    return this.box.toString();
  }

  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.box.scale(factor);
  }
}