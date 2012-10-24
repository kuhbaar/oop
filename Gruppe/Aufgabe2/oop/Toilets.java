package oop;

public class Toilets extends Infrastructure {
  public Toilets() {
    super("toilets");
  }

  public Toilets(String description) {
    super(description);
  }

  public Boolean provides(Infrastructure i) {
    if(i.getClass() == Toilets.class) return true;
    return super.provides(i);
  }
}