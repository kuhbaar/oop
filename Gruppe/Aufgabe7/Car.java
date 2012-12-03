import java.util.List;
import java.util.ArrayList;

public abstract class Car extends Thread implements Comparable<Car> {
  private final AI ai;
  private final String name;
  private final int MAX_POINTS = 10;

  private CellAccessor ca;
  private TerminationListener tl;
  private int maxW, maxH;
  private boolean driving = true;
  private Movement curMov;
  private Position bounds;
  private int points = 0;

  public Car(AI ai, String name) {
    this.ai = ai;
    this.name = name;
  }

  public void end() {
    this.driving = false;
  }

  @Override public void run() {
    while(this.driving) {
      /* calculate possible directions */
      List<Direction> possibleDirections = new ArrayList<Direction>();

      for(Direction d : getPossibleDirections()) {
        final AbsoluteDirection tempAbsDir = Helpers.rotateForMove(curMov.dir, d);
        final Position newPos = Helpers.move(curMov.pos, tempAbsDir);

        if(newPos.w < bounds.w && newPos.h < bounds.h && newPos.w >= 0 && newPos.h >= 0) {
          possibleDirections.add(d);
        }
      }

      final Maybe<Direction> maybeDirection = ai.getNextMove(curMov, possibleDirections);

      if(maybeDirection.isDefined()) {
        final Direction newDir = maybeDirection.get();

        final AbsoluteDirection tempAbsDir = Helpers.rotateForMove(curMov.dir, newDir);
        final Position newPos = Helpers.move(curMov.pos, tempAbsDir);

        final AbsoluteDirection newAbsDir = Helpers.rotate(curMov.dir, newDir);

        Cell oldCell  = ca.getCell(curMov.pos);
        Cell newCell = ca.getCell(newPos);

        /* lock cells */
        if(!oldCell.tryAcquire())
          continue;

        if(!newCell.tryAcquire()) {
          oldCell.release();
          continue;
        }

        /* check for collisions */
        if(newCell.hasCar()) {
          /* collisions */
          changePoints(1);
          /* TODO: check direction of other car */
          newCell.gotHit(newAbsDir);
        } else {
          /* update position */
          oldCell.removeCar();
          newCell.addCar(this);

          this.curMov = new Movement(newPos, newAbsDir);
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
