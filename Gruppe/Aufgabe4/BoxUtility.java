import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BoxUtility<P> {

  /* gibt eine Liste zurück, die 2 Elemente beinhaltet:
  die maximale höhe und breite der Objekte in der Liste */
  public List<Integer> getMaxDimensions(List<List<P>> xss) {
    int max_width = 0, max_height = 0;

    for(List<P> xs : xss) {
      for(P x : xs) {
        final String s = x.toString();
        final String[] lines = s.split("\n");

        if(lines.length > max_height)
          max_height = lines.length;

        if(lines.length > 0 && lines[0].length() > max_width)
          max_width = lines[0].length();
      }
    }

    return Arrays.asList(max_width, max_height);
  }

  /* gibt eine Liste der Zeichenketten zurück, die aus der 2-dimensionalen Liste mit Bildern generiert wird */
  public List<String> stringify(List<List<P>> xss, int max_width, int max_height) {
    List<String> temp = new ArrayList<String>();

    for(List<P> xs : xss) {
      for(int i = 0; i < max_height; i++) {
        String out = "";

        for(P x : xs) {
          final String s = x.toString();
          final String[] lines = s.split("\n");
          if(i < lines.length) {
            out += lines[i];
            for(int j = 0; j < (max_width - lines[i].length()); j++)
              out += " ";
          } else {
            for(int j = 0; j < max_width; j++)
              out += " ";            
          }
        }

        temp.add(out);
      }
    }

    return temp;
  }

}