package oop;

/* a disabled toilet infrastructure */
public class DisabledToilets extends Toilets {
  public DisabledToilets() {
    super("disabled toilets");
  }

  public DisabledToilets(String description) {
    super(description);
  }

  /* true if i is a DisabledToilet, or if it is provided by DisabledToilets
      superclass (eg because it's a normal toilet) */
  public Boolean provides(Infrastructure i) {
    if(i.getClass() == DisabledToilets.class) return true;
    return super.provides(i);
  }
}