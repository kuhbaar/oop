import java.util.List;
import java.util.Arrays;

public class FastCar extends Car {
  public FastCar(AI ai, String name) {
    super(ai, name);
  }

  /* returns how long (in milliseconds) the car should sleep between moves */
  protected int getSleepTime() {
    return 13;
  }

  /* returns the list of possible directions the car can drive in */
  protected List<Direction> getPossibleDirections() {
    return Arrays.asList(Direction.FORWARD, Direction.FORWARD_LEFT, Direction.FORWARD_RIGHT);
  }
}
