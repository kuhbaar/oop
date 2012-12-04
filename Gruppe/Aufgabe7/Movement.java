/*a class used to save the position and absolute direction of a car*/
public class Movement {
  public final Position pos;
  public final AbsoluteDirection dir;

  public Movement(Position p, AbsoluteDirection d) {
    this.pos = p;
    this.dir = d;
  }
}

