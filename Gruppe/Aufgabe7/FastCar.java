import java.util.List;
import java.util.Arrays;

public class FastCar extends Car {
  public FastCar(AI ai, String name) {
    super(ai, name);
  }

  protected int getSleepTime() {
    return 13;
  }

  protected List<Direction> getPossibleDirections() {
    return Arrays.asList(Direction.FORWARD, Direction.FORWARD_LEFT, Direction.FORWARD_RIGHT);
  }
}
