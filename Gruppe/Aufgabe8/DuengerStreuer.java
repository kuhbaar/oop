@AuthorClass(author="Jakub Zarzycki")
public class DuengerStreuer extends Maschine{
  private final double behaelter;

  /* creates a DuengerStreuer with vol as behaelter */
  public DuengerStreuer(double vol) {
    this.behaelter = vol;
  }

  /* returns an instance of Some class with value of behaelter in it */
  @Override
  public MaybeNumber getBehaelter() { return new Some(this.behaelter); }
}
