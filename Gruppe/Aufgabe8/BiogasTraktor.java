@AuthorClass(author="Jakub Zarzycki")
public class BiogasTraktor extends Traktor{
  private double verbrauch = 0.0;

  /* creates a BiogasTraktor with given name and Maschine m*/
  public BiogasTraktor(String name, Maschine m){
    super(name, m);
  }

  /* adds the menge to the verbrauch */
  public void changeVerbrauch(double menge) {
    this.verbrauch += menge;
  }

  /* returns the verbrauch */
  public double getVerbrauch() {
    return this.verbrauch;
  }
}
