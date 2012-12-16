public class Doppelkeks extends Keks{
  private final Fuellung fuelle;

  public Doppelkeks(Form f, Teig t, Fuellung fu){
    super(f,t);
    this.fuelle = fu;
  }

  public Fuellung getFuellung() {
    return fuelle;
  }

  @Override
  public String toString(){
    return "Doppelkeks " + this.form + " " + this.teig + " " + this.fuelle;
  }

  @Override public boolean equals(Object o) {
    if(o instanceof Doppelkeks) {
      Doppelkeks that = (Doppelkeks) o;
      return this.getTeig().equals(that.getTeig()) && this.getFuellung().equals(that.getFuellung()) &&
        this.getForm().equals(that.getForm());
    } else {
      return false;
    }
  }

  @Override public int hashCode() {
    return this.getTeig().hashCode() + this.getFuellung().hashCode() + this.getForm().hashCode();
  }
}
