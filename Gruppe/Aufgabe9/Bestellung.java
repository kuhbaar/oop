import java.util.Map;
import java.util.HashMap;

public class Bestellung{
  private HashMap<Keks, Integer> map;

  public Bestellung(){
    this.map = new HashMap<Keks, Integer>();
  }

  public void addKeks(int n, Keks k){
    map.put(k, n);
  }

  public void drucke(){
    String out = "Bestellungen:\n";
    for(Keks k : map.keySet()){
      out += "\t" + map.get(k) + "x " + k.toString() + "\n";
    }

    System.out.println(out);
  }
}