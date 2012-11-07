package oop;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/* simple directory to look up locations by infrastructure */
public class LocationDirectory {
  /* create a new empty directory */
  public LocationDirectory() {
    this.locations = new ArrayList<Location>();
  }
  
  /* add a new location to this directory - this will modify the internal state
     of this object ! */
  public void add(Location l) {
    locations.add(l);
  }

  /* returns a list of locations that provide the infrastructure i */
  public List<Location> getLocationsWithInfrastructure(Infrastructure i) {
    return getLocationsWithInfrastructure(Arrays.asList(i));
  }

  /* returns a list of locations that provide all the infrastructure specified
     by is. Locations are immutable, so the elements of this list will never
     change. */
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