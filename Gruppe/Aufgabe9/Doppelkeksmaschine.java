import java.lang.RuntimeException;

public class Doppelkeksmaschine implements Keksmaschine{
  private Keks k;
  private Fuellung f;

  public Doppelkeksmaschine(){
    this.k = null;
  }

  public void gebeKeks(Keks ks){
    this.k = new Keks(ks);
  }

  public void gebeFuellung(Fuellung f){
    this.f = f;
  }

  public Keks backe(){
    if(k == null) throw new RuntimeException();
    return new Doppelkeks(k.getForm(), k.getTeig(), f);
  }

}