import java.util.ArrayList;
import java.util.List;

@AuthorClass(author="Jakub Zarzycki")
public class Bauernhof{
  private final String name;
  private final MyMap traktoren;

  public Bauernhof(String name){
    this.name = name;
    this.traktoren = new MyMap();
  }

  public void addTraktor(Traktor t){
    traktoren.put(t.getID(), t);
  }

  public void delTraktor(String id){
    traktoren.remove(id);
  }

  public void changeTraktor(String id, Maschine m){
    Object o = traktoren.get(id);
    if(o instanceof Traktor) {
      Traktor t = (Traktor) o;
      t.changeEinsatzart(m);
    } else {
      throw new RuntimeException("can never happen");
    }
  }


  public double getHoursComplete(){
    double sum=0;


    for(Object o : traktoren) {
      if(o instanceof Traktor) {
        Traktor t = (Traktor) o;
        sum +=t.getStunden();
      }
    }
    return sum/traktoren.size();
  }
 /*
  public double getHoursSow(){
    double sum=0;
    int count = 0;
    for(Traktor t: traktoren){
      if(t.getMaschineVar() instanceof double) {
        count++;
        sum += t.getStunden();
      }


    }
    return sum/count;
  }

  public double getHoursDrill(){
    double sum =0;
    int count=0;
    for(Traktor t: traktoren){
      if(t.getMaschineVar() instanceof int) {
        count++;
        sum += t.getStunden();
      }


    }
    return sum/count;
  }

  */

  // TODO stat-werte berechnen
}
