public class DrillMaschine implements Maschine<Integer>{
  private final Integer saeschare;

  public DrillMaschine(int anz){
    this.saeschare = new Integer(anz);
  }

  public Integer getVar(){ return saeschare; }

}