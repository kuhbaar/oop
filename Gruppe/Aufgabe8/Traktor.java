import java.lang.Number;

@AuthorClass(author="Jakub Zarzycki")
public abstract class Traktor {
  protected final String id;

  protected int stunden;
  protected Maschine m;

  public Traktor(String name){
    this.id = name;
    this.stunden = 0;
    this.m = new Maschine();
  }

  @AuthorMethod(author="Julian Schrittwieser")
  public String getID() {
    return this.id;
  }

  public int getStunden(){ return this.stunden; }

  public MaybeNumber getSaeschere() {
    return m.getSaeschere();
  }

  @AuthorMethod(author="Julian Schrittwieser")
  public MaybeNumber getBehaelter() {
    return m.getBehaelter();
  }

  public void incrStunden(){ this.stunden++; }

  public void changeEinsatzart(Maschine m){
    this.m = m;
  }

}
