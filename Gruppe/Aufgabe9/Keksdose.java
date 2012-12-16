import java.util.Map;
import java.util.HashMap;

public class Keksdose{
  private final HashMap<Keks, Integer> kekse;

  public Keksdose(){
    this.kekse = new HashMap<Keks, Integer>();
  }

  public void addKeks(Keks k){
    if(kekse.containsKey(k))
      kekse.put(k,kekse.get(k)+1);
    else
      kekse.put(k,1);
  }

  public void inhalt(){
    String out = "Inhalt der Keksdose:\n";
    for(Keks k : kekse.keySet()){
      out += "\t" + kekse.get(k) + "x " + k.toString() + "\n";
    }

    System.out.println(out);
  }
}