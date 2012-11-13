import java.util.List;
import java.util.ArrayList;

public class Scaled<P extends Pict> implements Pict {
  private final List<List<P>> xss;
  private final BoxUtility<P> utility = new BoxUtility<P>();
  private FreeBox box;

  public Scaled(List<List<P>> xss) {
    this.xss = new ArrayList<List<P>>(xss);
    scale(1.0);
  }

  public String toString() {
    return this.box.toString();
  }

  public void scale(double factor) {
    for(List<P> xs : xss)
      for(P x : xs)
        x.scale(factor);


    final List<Integer> dims = utility.getMaxDimensions(xss);
    int max_width = dims.get(0);
    int max_height = dims.get(1);

    this.box = new FreeBox(utility.stringify(xss, max_width, max_height));
  }

}
