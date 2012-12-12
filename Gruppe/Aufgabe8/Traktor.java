import java.lang.Number;

/* Traktor class with unique id */
@AuthorClass(author="Jakub Zarzycki")
public abstract class Traktor {
  protected final String id; //can't be Null/empty

  protected int stunden;
  protected Maschine m;

  /* creates a new Traktor with name as id, 0 stunden and m as Maschine */
  public Traktor(String name, Maschine m){
    this.id = name;
    this.stunden = 0;
    this.m = m;
  }

  /* returns id of the Traktor */
  @AuthorMethod(author="Julian Schrittwieser")
  public String getID() {
    return this.id;
  }

  /* returns stunden of the Traktor */
  public int getStunden(){ return this.stunden; }

  /* returns an Instance of a class implementing MaybeNumber, either:
    None - the Maschine Type hasn't been defined or isn't a DrillMaschine or
    Some - the Maschine is a DrillMaschine */
  public MaybeNumber getSaeschere() {
    return m.getSaeschere();
  }

  /* returns an Instance of a class implementing MaybeNumber, either:
    None - the Maschine Type hasn't been defined or isn't a DuengerStreuer or
    Some - the Maschine is a DuengerStreuer */
  @AuthorMethod(author="Julian Schrittwieser")
  public MaybeNumber getBehaelter() {
    return m.getBehaelter();
  }

  /* adds n to stunden */
  public void changeStunden(int n){ this.stunden += n; }

  /* changes the Maschine of the Traktor to m */
  public void changeEinsatzart(Maschine m){
    this.m = m;
  }

}
