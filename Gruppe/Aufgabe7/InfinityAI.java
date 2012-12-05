/*AI used to turn left each turn*/

import java.util.List;

public class InfinityAI extends AI {
  private int index = 0;
  /* tries to drive around in a figure 8 / infinity symbol */
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    index = (index + 1) % 8;

    if(index < 4) {
      if(possibleDirections.contains(Direction.LEFT)) {
        return new Some<Direction>(Direction.LEFT);
      } else if(possibleDirections.contains(Direction.FORWARD_LEFT)) {
        return new Some<Direction>(Direction.FORWARD_LEFT);
      } else {
        return new None<Direction>();
      }
    } else {
      if(possibleDirections.contains(Direction.RIGHT)) {
        return new Some<Direction>(Direction.RIGHT);
      } else if(possibleDirections.contains(Direction.FORWARD_RIGHT)) {
        return new Some<Direction>(Direction.FORWARD_RIGHT);
      } else {
        return new None<Direction>();
      }
    }
  }
}
