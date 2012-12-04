import java.util.List;

public class StandingAI extends AI {
  /*returns and empty direction to have the car stand in place*/
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    return new None<Direction>();
  }
}
