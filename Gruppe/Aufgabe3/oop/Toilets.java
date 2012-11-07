package oop;

/* toilet infrastructure */
public class Toilets extends Infrastructure {
  public Toilets() {
    super("toilets");
  }

  public Toilets(String description) {
    super(description);
  }

  /* true iff i is a Toilet. */
  public Boolean provides(Infrastructure i) {
    if(i.getClass() == Toilets.class) return true;
    return super.provides(i);
  }
}