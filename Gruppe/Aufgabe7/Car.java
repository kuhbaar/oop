import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public abstract class Car extends Thread implements Comparable<Car> {
  private final AI ai;
  private final String name;
  private final int MAX_POINTS = 10;
  private final int MAX_MOVES = 42;
  private final CountDownLatch latch = new CountDownLatch(1);

  private CellAccessor ca;
  private TerminationListener tl;
  private int maxW, maxH;
  private boolean driving = true;
  private Movement curMov;
  private Position bounds;
  private int points = 0;
  private int numMoves = 0;

  /* create a new car with a given AI (responsible for calculating the next move)
     and a given name */
  public Car(AI ai, String name) {
    this.ai = ai;
    this.name = name;
    this.setName(name);
  }

  /* stop driving around - sets a variable that will cause the main loop of the
     thread to end */
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

  /* calculate the next movement from a given direction. this is the next cell
     the car will try to move to, including its new absolute direction */
  private Movement calculateNextMovement(Direction direction) {
    final AbsoluteDirection tempAbsDir = Helpers.rotateForMove(curMov.dir, direction);
    final Position newPos = Helpers.move(curMov.pos, tempAbsDir);

    final AbsoluteDirection newAbsDir = Helpers.rotate(curMov.dir, direction);
    return new Movement(newPos, newAbsDir);
  }

  /* run method of this thread, loops while the car is still driving around. 
     Can be stopped by calling end(). For each step, calculates a new cell to move
     to with the AI and then tries to drive there. If there's a collision, calculates
     points and stays in the current cell. Otherwise, the car moves to the new cell.
     Sleeps for getSleepTime() ms after each step */
  @Override public void run() {
    while(this.driving) {
      final List<Direction> possibleDirections = calculatePossibleDirections();    
      final Maybe<Direction> maybeDirection = ai.getNextMove(curMov, possibleDirections);

      if(maybeDirection.isDefined()) {
        final Direction newDir = maybeDirection.get();
        final Movement newMov = calculateNextMovement(newDir);

        Cell oldCell  = ca.getCell(curMov.pos);
        Cell newCell = ca.getCell(newMov.pos);

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
          newCell.gotHit(newMov.dir);  /* tell other car it was hit to deduct points */
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

      try { Thread.sleep(this.getSleepTime()); } 
      catch (java.lang.InterruptedException ex) { driving = false; }
    }

    this.latch.countDown();         // stop running - release our latch
  }

  /* returns how long (in milliseconds) the car should sleep between moves */
  protected abstract int getSleepTime();

  /* returns the list of possible directions the car can drive in */
  protected abstract List<Direction> getPossibleDirections();

  /* handle a hit from a given absolute direction - if it was a frontal crash,
     nothing happens. Otherwise, deduct a point */
  public void gotHit(AbsoluteDirection d) {
    final AbsoluteDirection opposite = Helpers.rotateLeft(d, 4);
    if(this.curMov.dir.equals(opposite)) {
      /* frontal crash - nothing happens */
    } else {
      changePoints(-1);
    }
  }

  /* adjust the internal point counter and check if this car has already won 
     (by having >= MAX_POINTS) */
  private void changePoints(int p) {
    points += p;
    if(points >= MAX_POINTS) {
      this.driving = false;
      Debug.info("WWINNNNERERRR !!!!");
      // game is over, car has won
      tl.notifyVictory(this);
    }
  }

  /* set the CellAccessor, used to get access to cells the car wants to move 
     away from or to */
  public void setCellAccessor(CellAccessor ca) {
    this.ca = ca;
  }

  /* set the TerminationListener, used to notify the main thread that this car has
     either won or run out of moves */
  public void setTerminationListener(TerminationListener tl) {
    this.tl = tl;
  }

  /* sets the maximum dimensions of the playing field, used to check if a car wants
     to move out of bounds */
  public void setDimension(int maxW, int maxH) {
    this.bounds = new Position(maxW, maxH);
  }

  /* set the initial position and direction of a car */
  public void setInitialPosition(int w, int h, AbsoluteDirection d) {
    this.curMov = new Movement(new Position(w, h), d);

    Cell cell  = ca.getCell(curMov.pos);

    while(!cell.tryAcquire()) {
    }
    cell.addCar(this);
    cell.release();
  }

  /* returns a description of the current car, consisting of the name of the class
     of this object, the name of the AI's class and the name given to this car,
     as well as the current points */
  public String getDescription() {
    String desc = String.format("%s (%s)", this.getClass().getCanonicalName(),
      this.ai.getClass().getCanonicalName());
    return String.format("%-25s %7s: %3d points", desc, this.name, this.points);
  }

  /* represent this car as a string - returns a single character showing in which
     direction the car is facing */
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

  /* compare to another car by number of points. used for sorting the highscore list */
  public int compareTo(Car that) {
    return that.points - this.points;
  }

  /* wait for this car to stop moving */
  public void await() throws java.lang.InterruptedException {
    this.latch.await();
  } 
}
