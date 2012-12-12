@AuthorClass(author="Jakub Zarzycki")
public class DrillMaschine extends Maschine{
  private final int saeschare;

  /* creates a DrillMaschine with anz as saeschare */
  public DrillMaschine(int anz){
    this.saeschare = anz;
  }

  /* returns an instance of Some class with value of saeschere in it */
  @Override
  public MaybeNumber getSaeschere(){ return new Some(this.saeschare);}

}
