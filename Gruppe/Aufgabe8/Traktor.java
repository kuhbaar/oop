import java.lang.Number;

@AuthorClass(author="Jakub Zarzycki")
public abstract class Traktor<T extends Number>{
  protected final String id;

  protected int stunden;
  protected T verbraucht;
  protected Maschine m;

  public Traktor(String name){
    this.id = name;
    this.stunden = 0;
    //this.verbraucht = (Class<T>) new Double(0);
  }
  @AuthorMethod(author="Karli")
  public int getStunden(){ return this.stunden; }
  @AuthorMethod(author="Karsi")
  public T getVerbraucht(){ return this.verbraucht; }
  public double getMaschineVar(){
    if(m.getSaeschere() != 0)  return m.getSaeschere();
    else if(m.getBehaelter() != 0) return m.getBehaelter();
    else return 0;
  }

  public void incrStunden(){ this.stunden++; }
  public void changeVerbraucht(int menge){
    //this.verbraucht += verbraucht + (Class<T>) menge;
  }
  public void changeEinsatzart(Maschine m){
    this.m = m;
  }

}