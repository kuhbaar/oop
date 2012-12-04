import java.util.List;
import java.util.ArrayList;

public abstract class Car extends Thread implements Comparable<Car> {
  private final AI ai;
  private final String name;
  private final int MAX_POINTS = 10;
  private final int MAX_MOVES = 42;

  private CellAccessor ca;
  private TerminationListener tl;
  private int maxW, maxH;
  private boolean driving = true;
  private Movement curMov;
  private Position bounds;
  private int points = 0;
  private int numMoves = 0;

  public Car(AI ai, String name) {
    this.ai = ai;
    this.name = name;
  }

  public void end() {
    this.driving = false;
  }

  /* calculates all possible directions the car can drive in right now, ie those,
     possible by the make of the car (returned by getPossibleDirections()) minus
     those blocked by the borders of the field. if there are no possible directions,
     the list is empty */
  private List<Direction> calculatePossibleDirections() {
    List<Direction> possibleDirections = new ArrayList<Direction>();

    for(Direction d : getPossibleDirections()) {
      final AbsoluteDirection tempAbsDir = Helpers.rotateForMove(curMov.dir, d);
      final Position newPos = Helpers.move(curMov.pos, tempAbsDir);

      if(newPos.w < bounds.w && newPos.h < bounds.h && newPos.w >= 0 && newPos.h >= 0) {
        possibleDirections.add(d);
      }
    }

    return possibleDirections;
  }

  private Movement calculateNextMovement(Direction direction) {
    final AbsoluteDirection tempAbsDir = Helpers.rotateForMove(curMov.dir, newDir);
    final Position newPos = Helpers.move(curMov.pos, tempAbsDir);

    final AbsoluteDirection newAbsDir = Helpers.rotate(curMov.dir, newDir);
    return new Movement(newPos, newAbsDir);
  }

  @Override public void run() {
    while(this.driving) {
      final List<Direction> possibleDirections = calculatePossibleDirections();    
      final Maybe<Direction> maybeDirection = ai.getNextMove(curMov, possibleDirections);

      if(maybeDirection.isDefined()) {
        final Direction newDir = maybeDirection.get();
        final Movement newMov = calculateNextMovement(newDir);

        Cell oldCell  = ca.getCell(curMov.pos);
        Cell newCell = ca.getCell(newPos);

        /* lock cells */
        if(!oldCell.tryAcquire())
          continue;

        if(!newCell.tryAcquire()) {
          oldCell.release();
          continue;
        }

        
        if(newCell.hasCar()) {        /* check for collisions */
          /* collision */
          changePoints(1);
          newCell.gotHit(newAbsDir);  /* tell other car it was hit to deduct points */
        } else {
          /* no collision, update position */
          oldCell.removeCar();
          newCell.addCar(this);

          this.curMov = newMov;
          numMoves += 1;
          if(numMoves >= MAX_MOVES) {
            tl.notifyOutOfMoves(this);
          }
        }

        /* free cells */
        oldCell.release();
        newCell.release();
      }

      try {
        Thread.sleep(this.getSleepTime());
      } catch (java.lang.InterruptedException ex) {
        driving = false;
      }
    }
  }

  protected abstract int getSleepTime();

  protected abstract List<Direction> getPossibleDirections();

  public void gotHit(AbsoluteDirection d) {
    final AbsoluteDirection opposite = Helpers.rotateLeft(d, 4);
    if(this.curMov.dir.equals(opposite)) {
      /* frontal crash - nothing happens */
    } else {
      changePoints(-1);
    }
  }

  private void changePoints(int p) {
    points += p;
    if(points >=  MAX_POINTS) {
      this.driving = false;
      Debug.info("WWINNNNERERRR !!!!");
      // game is over, car has won
      tl.notifyVictory(this);
    }
  }

  public void setCellAccessor(CellAccessor ca) {
    this.ca = ca;
  }

  public void setTerminationListener(TerminationListener tl) {
    this.tl = tl;
  }

  public void setDimension(int maxW, int maxH) {
    this.bounds = new Position(maxW, maxH);
  }

  public void setInitialPosition(int w, int h, AbsoluteDirection d) {
    this.curMov = new Movement(new Position(w, h), d);

    Cell cell  = ca.getCell(curMov.pos);

    while(!cell.tryAcquire()) {
    }
    cell.addCar(this);
    cell.release();

  }

  public String getDescription() {
    String desc = String.format("%s (%s)", this.getClass().getCanonicalName(),
      this.ai.getClass().getCanonicalName());
    return String.format("%-25s %7s: %3d points", desc, this.name, this.points);
  }

  @Override public String toString() {
    switch(this.curMov.dir) {
      case N:
        return "A";
      case W:
        return "<";
      case S:
        return "V";
      case E:
        return ">";
      default:
        assert(false);
    }
    throw new RuntimeException("unreachable");
  }

  public int compareTo(Car that) {
    return that.points - this.points;
  }
}
