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
 
  public double getHoursSow(){
    double sum=0;
    int count = 0;
    for(Object o: traktoren){
      if(o instanceof Traktor) {
        Traktor t=(Traktor) o;
        if(t.getBehaelter().isDefined()) {
          count++;
          sum += t.getStunden();
        }
      }


    }
    return sum/count;
  }

  public double getHoursDrill(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){
      if(o instanceof Traktor) {
        Traktor t=(Traktor) o;
        if(t.getSaeschere().isDefined()) {
          count++;
          sum += t.getStunden();
        }
      }


    }
    return sum/count;
  }


  public double getHoursDiesel(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){
      if(o instanceof BiogasTraktor) {
        Traktor t=(Traktor) o;
        count++;
        sum += t.getStunden();
      }
       

    }
    return sum/count;
  }

  public double getHoursBiogas(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){
      if(o instanceof DieselTraktor) {
        Traktor t=(Traktor) o;
        count++;
        sum += t.getStunden();
      }
       

    }
    return sum/count;
  }

  public double getDieselDrill(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof DieselTraktor) {
        Traktor t=(Traktor) o;
        if(t.getSaeschere().isDefined()) {
          count++;
          sum += t.getVerbrauch();
        }
      }
       

    }
    return sum/count;
  }


  public double getDieselSow(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof DieselTraktor) {
        Traktor t=(Traktor) o;
        if(t.getBehaelter().isDefined()) {
          count++;
          sum += t.getVerbrauch();
        }
      }
       

    }
    return sum/count;
  }

   public double getDiesel(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof DieselTraktor) {
        Traktor t=(Traktor) o;
        count++;
        sum += t.getVerbrauch();
        
      }
       

    }
    return sum/count;
  }

  public double getGasDrill(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof BiogasTraktor) {
        Traktor t=(Traktor) o;
        if(t.getSaeschere().isDefined()) {
          count++;
          sum += t.getVerbrauch();
        }
      }
       

    }
    return sum/count;
  }


  public double getGasSow(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof BiogasTraktor) {
        Traktor t=(Traktor) o;
        if(t.getBehaelter().isDefined()) {
          count++;
          sum += t.getVerbrauch();
        }
      }
       

    }
    return sum/count;
  }

   public double getGas(){
    double sum =0;
    int count=0;
    for(Object o: traktoren){

      if(o instanceof BiogasTraktor) {
        Traktor t=(Traktor) o;
        count++;
        sum += t.getVerbrauch();
        
      }
       

    }
    return sum/count;
  }


  // TODO stat-werte berechnen
}
