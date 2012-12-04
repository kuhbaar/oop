import java.util.List;
import java.util.Random;

public class RandomAI extends AI {
  private final Random r = new Random();

  /*returns a random direction out of the list of possible directions*/
  public Maybe<Direction> getNextMove(Movement m, List<Direction> possibleDirections) {
    if(possibleDirections.isEmpty()) {
      return new None<Direction>();
    } else {
      return new Some<Direction>(possibleDirections.get(r.nextInt(possibleDirections.size())));
    }
  }
}
