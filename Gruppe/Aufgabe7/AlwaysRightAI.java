/*AI used to turn left each turn*/

import java.util.List;

public class AlwaysRightAI extends AI {
  /* always tries to turn as far right as possible. Returns Some(direction) if
     possible, otherwise None() */
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    if(possibleDirections.contains(Direction.RIGHT)) {
      return new Some<Direction>(Direction.RIGHT);
    } else if(possibleDirections.contains(Direction.FORWARD_RIGHT)) {
      return new Some<Direction>(Direction.FORWARD_RIGHT);
    } else {
      return new None<Direction>();
    }
  }
}
