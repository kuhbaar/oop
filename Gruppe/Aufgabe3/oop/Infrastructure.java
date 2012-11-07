package oop;

/* concept of infrastructure, that actually doesn't provide any usable infrastructure
  (that's done by subclasses) */
public class Infrastructure {
  public Infrastructure(String description) {
    this.description = description;
  }
  
  /* GOOD: concrete pieces of infrastructure override this method, which allows
     them to provide different kind of infrastructure, even when they are not a 
     direct subclass, eg Toilets can provide Power, even though Toilet is not a
     subclass of Power. This makes it very easy to add new infrastructure without
     having to change old one.
   */
  public Boolean provides(Infrastructure i) {
    return false;
  }

  protected String description;
}