import java.util.List;
import java.util.Arrays;

public class FlexCar extends Car {
  public FlexCar(AI ai, String name) {
    super(ai, name);
  }

  protected int getSleepTime() {
    return 26;
  }

  protected List<Direction> getPossibleDirections() {
    return Arrays.asList(Direction.FORWARD, Direction.FORWARD_LEFT, Direction.FORWARD_RIGHT,
      Direction.LEFT, Direction.RIGHT);
  }
}
