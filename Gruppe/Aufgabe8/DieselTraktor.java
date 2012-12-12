@AuthorClass(author="Jakub Zarzycki")
public class DieselTraktor extends Traktor {
  private int verbrauch = 0;

  public DieselTraktor(String name, Maschine m){
    super(name, m);
  }

  /* adds the menge to the verbrauch of this Traktor */
  public void changeVerbrauch(int menge) {
    this.verbrauch += menge;
  }

  /* returns the verbrauch of this Traktor */
  public int getVerbrauch() {
    return this.verbrauch;
  }
}
