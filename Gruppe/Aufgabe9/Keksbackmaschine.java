public abstract class Keksbackmaschine implements Keksmaschine{
  protected Teig teig = null;

  public void gebeTeig(Teig t){
    this.teig = t;
  }
  public Keks backe(){
    return null;
  }
}