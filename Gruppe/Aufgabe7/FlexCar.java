import java.util.List;
import java.util.Arrays;

public class FlexCar extends Car {
  public FlexCar(AI ai, String name) {
    super(ai, name);
  }

  /* returns how long (in milliseconds) the car should sleep between moves */
  protected int getSleepTime() {
    return 26;
  }

  /* returns the list of possible directions the car can drive in */
  protected List<Direction> getPossibleDirections() {
    return Arrays.asList(Direction.FORWARD, Direction.FORWARD_LEFT, Direction.FORWARD_RIGHT,
      Direction.LEFT, Direction.RIGHT);
  }
}
