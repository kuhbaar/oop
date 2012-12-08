import java.lang.Number;

@Author(author="Jakub Zarzycki")
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

  public int getStunden(){ return this.stunden; }
  public T getVerbraucht(){ return this.verbraucht; }
  public Double getMaschineVar(){ return (Double)m.getVar(); }

  public void incrStunden(){ this.stunden++; }
  public void changeVerbraucht(int menge){
    //this.verbraucht += verbraucht + (Class<T>) menge;
  }
  public void changeEinsatzart(Maschine m){
    this.m = m;
  }

}