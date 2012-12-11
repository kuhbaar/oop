@AuthorClass(author="Jakub Zarzycki")
public class BiogasTraktor extends Traktor{
  private double menge = 0.0;

  public BiogasTraktor(String name){
    super(name);
  }

  @AuthorMethod(author="Julian")
  public void changeVerbrauch(double menge) {
    this.menge += menge;
  }

  @AuthorMethod(author="Julian")
  public double getVerbrauch() {
    return this.menge;
  }
}
