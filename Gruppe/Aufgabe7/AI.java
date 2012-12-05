import java.util.List;

public abstract class AI {
  /* calculate the next direction to move to from the current position and direction,
     and the list of possible directions. If a valid direction is determined,
     Some(direction) is returned, otherwise None().
     possibleDirections are relative to the current movement direction */
  abstract public Maybe<Direction> getNextMove(Movement m,
    List<Direction> possibleDirections);
}
