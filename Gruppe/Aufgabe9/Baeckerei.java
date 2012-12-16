import java.util.ArrayList;
import java.util.List;

public class Baeckerei{
  private final List<Bestellung> bestellungen;

  public Baeckerei(){
    this.bestellungen = new ArrayList<Bestellung>();
  }

  public void abgebeBestellung (Bestellung b){
    bestellungen.add(b);
  }

  
}