import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FreeBox implements Pict {
  protected final List<String> text;

  private double scale;

  public FreeBox(List<String> text) {
    this.text = new ArrayList<String>(text);
    this.scale = 1.0;
  }
  
  public String toString() {
    final int height = text.size();
    final int width = text.size() > 0 ? text.get(0).length() : 0;

    String out = "";
    for(int i = 0; i < Math.ceil(height * scale); i++) {
      for(int j = 0; j < Math.ceil(width * scale); j++) {
        out += text.get(i % height).charAt(j % width);
      }
      out += "\n";
    }
    
    return out.substring(0, out.length() - 1);  /* strip final newline */
  }

  public void scale(double factor) {
    assert(factor >= 0.1);
    assert(factor <= 10.0);

    this.scale = factor;
  }

}