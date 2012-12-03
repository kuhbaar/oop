public class Helpers {
  public static AbsoluteDirection rotateLeft(AbsoluteDirection d, int steps) {
    if(steps <= 0)
      return d;

    switch(d) {
      case N:
        return rotateLeft(AbsoluteDirection.NW, steps - 1);
      case NE:
        return rotateLeft(AbsoluteDirection.N, steps - 1);
      case E:
        return rotateLeft(AbsoluteDirection.NE, steps - 1);
      case SE:
        return rotateLeft(AbsoluteDirection.E, steps - 1);
      case S:
        return rotateLeft(AbsoluteDirection.SE, steps - 1);
      case SW:
        return rotateLeft(AbsoluteDirection.S, steps - 1);
      case W:
        return rotateLeft(AbsoluteDirection.SW, steps - 1);
      case NW:
        return rotateLeft(AbsoluteDirection.W, steps - 1);
      default:
        assert(false);
    }
    throw new RuntimeException("unreachable");
  }

  public static AbsoluteDirection rotateForMove(AbsoluteDirection absD, Direction dir) {
    switch(dir) {
      case FORWARD:
        return absD;
      case FORWARD_LEFT:
        return rotateLeft(absD, 1);
      case LEFT:
        return rotateLeft(absD, 2);
      case RIGHT:
        return rotateLeft(absD, 6);
      case FORWARD_RIGHT:
        return rotateLeft(absD, 7);
      default:
        assert(false);
    }
    throw new RuntimeException("unreachable");
  }

  public static AbsoluteDirection rotate(AbsoluteDirection absD, Direction dir) {
    switch(dir) {
      case FORWARD:
      case FORWARD_LEFT:
      case FORWARD_RIGHT:
        return absD;

      case LEFT:
        return rotateLeft(absD, 2);

      case RIGHT:
        return rotateLeft(absD, 6);
      default:
        assert(false);
    }
    throw new RuntimeException("unreachable");
  }

  public static Position move(Position p, AbsoluteDirection d) {
    switch(d) {
      case N:
        return new Position(p.w, p.h - 1);
      case NE:
        return new Position(p.w + 1, p.h - 1);
      case E:
        return new Position(p.w + 1, p.h);
      case SE:
        return new Position(p.w + 1, p.h + 1);
      case S:
        return new Position(p.w, p.h + 1);
      case SW:
        return new Position(p.w - 1, p.h + 1);
      case W:
        return new Position(p.w - 1, p.h);
      case NW:
        return new Position(p.w - 1, p.h - 1);
      default:
        assert(false);
    }
    throw new RuntimeException("unreachable");
  }
}

/*
  N,
  NE,
  E,
  SE,
  S,
  SW,
  W,
  NW
  */
