import java.util.ArrayList;
import java.util.List;

public class Baeckerei{
  private final List<Bestellung> bestellungen;

  public Baeckerei(){
    this.bestellungen = new ArrayList<Bestellung>();
  }

  public Keksdose abgebeBestellung (Bestellung b){
    Keksdose dose = new Keksdose();

    bestellungen.add(b);

    for(KeksPosten kp : b) {
      Keks k = kp.typ;
      Keksmaschine maschine = null;

      if(k instanceof Doppelkeks) {
        Doppelkeksmaschine m = new Doppelkeksmaschine();
        m.gebeKeks(k);
        m.gebeFuellung(((Doppelkeks) k).getFuellung());
        maschine = m;
      } else {
        Keksbackmaschine m = null;

        switch(k.getForm()) {
          case Rund:
            m = new KeksmaschineRund();
            break;
          case Mond:
            m = new KeksmaschineMond();
            break;
          case Weihnachtsmann:
            m = new KeksmaschineWeihnachtsmann();
            break;
          default:
            throw new RuntimeException("unknown form");
        }

        m.gebeTeig(k.getTeig());
        maschine = m;
      }

      for(int i = 0; i < kp.anzahl; i++) {
        dose.addKeks(maschine.backe());
      }
    }

    return dose;
  }


}
