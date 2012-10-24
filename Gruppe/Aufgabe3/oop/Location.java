package oop;

import java.util.List;
import java.util.ArrayList;

public class Location {
  public Location(String name) {
    this.name = name;
    this.infrastructure = new ArrayList<Infrastructure>();
  }

  public Location(Location l) {
    this.name = l.name;
    this.infrastructure = new ArrayList<Infrastructure>(l.infrastructure);
  }

  public String toString() { return this.name; }
  public String getName() { return name; }

  public Boolean hasInfrastructure(Infrastructure inf) {
    for(Infrastructure i : infrastructure) {
      if(i.provides(inf)) return true;
    }
    return false;
  }

  public Location add(Infrastructure i) {
    Location l = new Location(this);
    l.infrastructure.add(i);
    return l;
  }

  @Override public boolean equals(Object other) {
    if(this == other) return true;
    if(!(other instanceof Location)) return false;
    Location that = (Location) other;
    return this.name.equals(that.name) &&
      this.infrastructure.equals(that.infrastructure);
  }

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