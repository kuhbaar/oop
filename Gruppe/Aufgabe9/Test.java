public class Test {
  public static void main(String[] args) {
    Bestellung b = new Bestellung();
    Keksbackmaschine kmr = new KeksmaschineRund();
    Keksbackmaschine kmm = new KeksmaschineMond();
    Doppelkeksmaschine dkm = new Doppelkeksmaschine();

    kmr.gebeTeig(Teig.Muerbteig);
    Keks k1 = kmr.backe();
    kmm.gebeTeig(Teig.Schokoladenteig);
    Keks k2 = kmm.backe();
    dkm.gebeKeks(k1);
    dkm.gebeFuellung(Fuellung.Marmelade);
    Keks k3 = dkm.backe();

    b.addKeks(2,k1);
    b.addKeks(5,k2);
    b.addKeks(100,k3);
    b.drucke();

    Keksdose klaudia = new Keksdose();
    klaudia.addKeks(k1);
    klaudia.addKeks(k2);
    klaudia.addKeks(k2);
    klaudia.addKeks(k3);
    klaudia.inhalt();

    Baeckerei baeckerei = new Baeckerei();
    Keksdose john = baeckerei.abgebeBestellung(b);
    john.inhalt();
  }
}
