public class Doppelkeks extends Keks{
  private final Fuellung fuelle;

  public Doppelkeks(Form f, Teig t, Fuellung fu){
    super(f,t);
    this.fuelle = fu;
  }

  @Override
  public String toString(){
    return "Doppelkeks " + this.form + " " + this.teig + " " + this.fuelle;
  }
}