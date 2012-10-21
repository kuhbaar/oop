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

  public String toString() {
    return this.name;
  }

  public Boolean hasInfrastructure(Infrastructure inf) {
    for(Infrastructure i : infrastructure) {
      if(i.provides(inf)) return true;
    }
    return false;
  }

  public Location addInfrastructure(Infrastructure i) {
    Location l = new Location(this);
    l.infrastructure.add(i);
    return l;
  }

  protected String name;
  protected List<Infrastructure> infrastructure;
}