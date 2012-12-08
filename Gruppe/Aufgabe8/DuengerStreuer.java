public class DuengerStreuer implements Maschine<Double>{
  private final Double baehelter;

  public DuengerStreuer(double vol){
    this.baehelter = new Double(vol);
  }

  public Double getVar(){ return baehelter; }
}