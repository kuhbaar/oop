package oop;

import java.util.List;
import java.util.ArrayList;

public class Location {
  /* create a new location that doesn't provide any infrastructure at all */
  public Location(String name) {
    this.name = name;
    this.infrastructure = new ArrayList<Infrastructure>();
  }

  /* deep copy of a location */
  public Location(Location l) {
    this.name = l.name;
    this.infrastructure = new ArrayList<Infrastructure>(l.infrastructure);
  }

  /* for all the accessors: return / calculate the requested value */
  public String toString() { return this.name; }
  public String getName() { return name; }

  /* returns true if one of the infrastructures of this location provides the
     requested infrastructure i (this doesn't necessarily correlate with it 
     being the same class)
   */
  public Boolean hasInfrastructure(Infrastructure inf) {
    for(Infrastructure i : infrastructure) {
      if(i.provides(inf)) return true;
    }
    return false;
  }

  /* returns a new location that is the same as this, except that it also provides
     infrastructure i. The old location is not modified. */
  public Location add(Infrastructure i) {
    Location l = new Location(this);
    l.infrastructure.add(i);
    return l;
  }

  /* true iff the other object has the same identifying content and its class
     can be substituted for this one (Location)
  */
  @Override public boolean equals(Object other) {
    if(this == other) return true;
    if(!(other instanceof Location)) return false;
    Location that = (Location) other;
    return this.name.equals(that.name) &&
      this.infrastructure.equals(that.infrastructure);
  }


  /* a.equals(b) implies a.hashCode() == b.hashCode() */
  @Override public int hashCode() {
    if ( hashCode == 0 ) {
      hashCode = name.hashCode() +
        (infrastructure.hashCode() << 4);
    }
    return hashCode;
  }

  protected String name;
  protected List<Infrastructure> infrastructure;
  private int hashCode;
}