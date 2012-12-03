import java.util.List;

public class StandingAI extends AI {
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    return new None<Direction>();
  }
}
