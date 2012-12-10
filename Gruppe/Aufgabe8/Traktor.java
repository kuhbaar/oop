import java.lang.Number;

@AuthorClass(author="Jakub Zarzycki")
public abstract class Traktor {
  protected final String id;

  protected int stunden;
  protected Maschine m;

  public Traktor(String name){
    this.id = name;
    this.stunden = 0;
  }

  @AuthorMethod(author="Kuba")
  public int getStunden(){ return this.stunden; }

  @AuthorMethod(author="Kuba")
  public MaybeNumber getSaeschere() {
    return m.getSaeschere();
  }

  @AuthorMethod(author="Julian")
  public MaybeNumber getBehaelter() {
    return m.getBehaelter();
  }

  @AuthorMethod(author="Kuba")
  public void incrStunden(){ this.stunden++; }


  @AuthorMethod(author="Kuba")
  public void changeEinsatzart(Maschine m){
    this.m = m;
  }

}
