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

  public double getHoursSow(){
    double sum=0;
    int count = 0;
    for(Traktor t: traktoren){
      if(t.getBehaelter().isDefined()) {
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
      if(t.getSaeSchere().isDefined()) {
        count++;
        sum += t.getStunden();
      }


    }
    return sum/count;
  }

  public double getHoursDiesel(){
    double sum =0;
    int count=0;
    for(Traktor t: traktoren){
      if(t instanceof BiogasTraktor) {
        count++;
        sum += t.getStunden();
      }
       

    }
    return sum/count;
  }

  public double getHoursBiogas(){
    double sum =0;
    int count=0;
    for(Traktor t: traktoren){
      if(t instanceof DieselTraktor) {
        count++;
        sum += t.getStunden();
      }
       

    }
    return sum/count;
  }



  // TODO stat-werte berechnen
}
