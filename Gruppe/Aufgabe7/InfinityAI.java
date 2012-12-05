/*AI used to turn left each turn*/

import java.util.List;

public class InfinityAI extends AI {
  /* always tries to turn as far left as possible. Returns Some(direction) if
     possible, otherwise None() */
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    final AbsoluteDirection d = m.dir;
    final Position p = m.pos;

    if(possibleDirections.contains(Direction.LEFT)) {
      return new Some<Direction>(Direction.LEFT);
    } else if(possibleDirections.contains(Direction.FORWARD_LEFT)) {
      return new Some<Direction>(Direction.FORWARD_LEFT);
    } else {
      return new None<Direction>();
    }
  }
}
