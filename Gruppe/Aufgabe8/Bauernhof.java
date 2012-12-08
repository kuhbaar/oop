import java.util.ArrayList;
import java.util.List;

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

  public void changeTraktor(Traktor t){
    //Einsatzart des Traktoren ändern
  }
}