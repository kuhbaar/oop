package oop;

public class DisabledToilets extends Toilets {
  public DisabledToilets() {
    super("disabled toilets");
  }

  public DisabledToilets(String description) {
    super(description);
  }

  public Boolean provides(Infrastructure i) {
    if(i.getClass() == DisabledToilets.class) return true;
    return super.provides(i);
  }
}