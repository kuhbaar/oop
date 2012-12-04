/*a class used to save the position and absolute direction of a car*/
public class Movement {
  /* there is no need for accessors as these values are a) immutable, b) publicly
     accessible anyway and c) there won't every be a reason to change the
     implementation. If Java wasn't such a crappy language, it would even be possible
     to transparently introduce accessors after the fact. alas, it's not, but that
     doesn't matter here */
  public final Position pos;
  public final AbsoluteDirection dir;

  public Movement(Position p, AbsoluteDirection d) {
    this.pos = p;
    this.dir = d;
  }
}

