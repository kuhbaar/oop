import java.util.List;

public class AlwaysLeftAI extends AI {
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    final AbsoluteDirection d = m.dir;
    final Position p = m.pos;

    if(possibleDirections.contains(Direction.LEFT)) {
      return new Some<Direction>(Direction.LEFT);
    } else {
      return new None<Direction>();
    }
  }
}
