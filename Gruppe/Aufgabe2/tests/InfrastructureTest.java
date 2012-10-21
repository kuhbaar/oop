package tests;

import java.util.List;
import java.util.ArrayList;
import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;
import oop.Location;
import oop.Toilets;
import oop.DisabledToilets;
import oop.MusicGroup;

public class InfrastructureTest extends AbstractTest {
  @BeforeClass
  public void InitializeCommonValues() {

  }

  @UnitTest
  public void addInfrastructureToLocation() {
    Location l = 
      new Location("Staatsoper")
        .addInfrastructure(new Toilets("Frauenklo"))
        .addInfrastructure(new Toilets("Maennerklo"));

    assertTrue(l.hasInfrastructure(new Toilets()));
    assertFalse(l.hasInfrastructure(new DisabledToilets()));
  }
}