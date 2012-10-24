package oop;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LocationDirectory {
  public LocationDirectory() {
    this.locations = new ArrayList<Location>();
  }
  
  public void add(Location l) {
    locations.add(l);
  }

  public List<Location> getLocationsWithInfrastructure(Infrastructure i) {
    return getLocationsWithInfrastructure(Arrays.asList(i));
  }


  public List<Location> getLocationsWithInfrastructure(List<Infrastructure> is) {
    List<Location> ls = new ArrayList<Location>();

    for(Location l : locations) {
      Boolean hasAllInfrastructures = true;

      for(Infrastructure i : is)
        if(!l.hasInfrastructure(i)) {
          hasAllInfrastructures = false;
          break;
        }

      if(hasAllInfrastructures)
        ls.add(l);
    }

    return ls;
  }



  protected List<Location> locations;
}