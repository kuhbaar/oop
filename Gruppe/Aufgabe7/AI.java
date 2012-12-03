import java.util.List;

public abstract class AI {
  /* possibleDirections are relative to movement direction */
  abstract public Maybe<Direction> getNextMove(Movement m,
    List<Direction> possibleDirections);
}
