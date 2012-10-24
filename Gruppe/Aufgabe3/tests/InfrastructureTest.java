package tests;

import java.util.List;
import java.util.ArrayList;
import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;
import oop.Location;
import oop.Toilets;
import oop.DisabledToilets;
import oop.LocationDirectory;

public class InfrastructureTest extends AbstractTest {
  @BeforeClass
  public void InitializeCommonValues() {

  }

  @UnitTest
  public void addInfrastructureToLocation() {
    Location l = 
      new Location("Staatsoper")
        .add(new Toilets("Frauenklo"))
        .add(new Toilets("Maennerklo"));

    assertTrue(l.hasInfrastructure(new Toilets()));
    assertFalse(l.hasInfrastructure(new DisabledToilets()));
  }

  @UnitTest
  public void locationDirectoryTests() {
    LocationDirectory d = new LocationDirectory();

    d.add(new Location("Ballhaus").
      add(new DisabledToilets()));
    d.add(new Location("Bruchbude"));

    List<Location> l = d.getLocationsWithInfrastructure(new DisabledToilets());
    assertEqual(l.size(), 1);
    assertEqual(l.get(0).getName(), "Ballhaus");
  }
}