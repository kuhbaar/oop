import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Bestellung implements Iterable<KeksPosten> {
  private final HashMap<Keks, Integer> map;

  public Bestellung(){
    this.map = new HashMap<Keks, Integer>();
  }

  public void addKeks(int n, Keks k){
    map.put(k, map.containsKey(k) ? map.get(k) + n : n);
  }

  public void drucke(){
    String out = "Bestellungen:\n";
    for(Keks k : map.keySet()){
      out += "\t" + map.get(k) + "x " + k.toString() + "\n";
    }

    System.out.println(out);
  }

  public Iterator<KeksPosten> iterator() {
    ArrayList<KeksPosten> temp = new ArrayList<KeksPosten>();

    for(Keks k : map.keySet()) {
      temp.add(new KeksPosten(k, map.get(k)));
    }

    return temp.iterator();
  }
}
