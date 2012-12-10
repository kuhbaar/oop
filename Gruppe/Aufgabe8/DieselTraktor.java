@AuthorClass(author="Jakub Zarzycki")
public class DieselTraktor extends Traktor {
  private int menge = 0;

  public DieselTraktor(String name){
    super(name);
  }

  @AuthorMethod(author="Julian")
  public void changeVerbrauch(int menge) {
    this.menge += menge;
  }

  @AuthorMethod(author="Julian")
  public int getVerbrauch() {
    return this.menge;
  }
}
