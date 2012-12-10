import java.util.ArrayList;
import java.util.List;

@AuthorClass(author="Jakub Zarzycki")
public class Bauernhof{
  private final String name;
  private final List<Traktor> traktoren;

  public Bauernhof(String name){
    this.name = name;
    this.traktoren = new ArrayList<Traktor>();
  }

  public void addTraktor(Traktor t){
    traktoren.add(t);
  }

  public void delTraktor(Traktor t){
    traktoren.remove(t);
  }

  public void changeTraktor(Traktor t, Maschine m){
    t.changeEinsatzart(m);
  }


  public double getHoursComplete(){
    double sum=0;

    for(Traktor t: traktoren){
      sum +=t.getStunden();
    }
    return sum/traktoren.size();
  }

  /*public double getHoursSow(){
    double sum=0;
    for(Traktor t: traktoren){
      //if(t.)
    }
  }*/

  // TODO stat-werte berechnen
}
