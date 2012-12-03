import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Field {
  private final Cell field[][];
  private final ArrayList<Car> cars = new ArrayList<Car>();
  private final Random r = new Random();
  private final int w;
  private final int h;
  private boolean raceRunning = false;
  private CountDownLatch latch = new CountDownLatch(1);

  private class CellAccessorImpl implements CellAccessor {
    public Cell getCell(Position p) {
      return field[p.w][p.h];
    }
  }

  private class TerminationListenerImpl implements TerminationListener {
    public void notifyVictory(Car c) {
      carWon(c);
    }
  }


  public Field(int w, int h) {
    this.w = w;
    this.h = h;

    this.field = new Cell[w][h];
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        this.field[i][j] = new Cell();
  }

  private synchronized void carWon(Car c) {
    if(raceRunning) {
      raceRunning = false;

      for(Car car : cars)
        car.end();

      Debug.info("car has won: " + c.getDescription());

      latch.countDown();
    }

  }

  public void add(Car c) {
    c.setCellAccessor(new CellAccessorImpl());
    c.setTerminationListener(new TerminationListenerImpl());

    int tempW, tempH;
    do {
      tempW = r.nextInt(w);
      tempH = r.nextInt(h);
    } while(this.field[tempW][tempH].hasCar());
    c.setInitialPosition(tempW, tempH, Helpers.rotateLeft(AbsoluteDirection.N, 2*r.nextInt(4)));

    c.setDimension(w, h);
    cars.add(c);
  }

  public void runWithMaxDuration(int seconds) {
    raceRunning = true;
    Debug.info(this.toString());

    for(Car c : cars)
      c.start();

    for(int i = 0; i < 10000; i++) {
      try {
        if(latch.await(100, TimeUnit.MILLISECONDS)) {
          /* somebody just won */
          return;
        } else {
          /* race still ongoing, continue to wait */
        }
      } catch (InterruptedException e) {
        /* somebody won the race */
        Debug.error("main thread shouldn't be interruped!");
      }
      Debug.info(this.toString());
    }

    Debug.info("over");

    for(Car c : cars)
      c.end();
  }

  @Override public String toString() {
    lockAll();
    String out = "";

    for(int j = 0; j < h; j++) {
      for(int i = 0; i < w; i++) {
        out += this.field[i][j].toString();
      }
      out += "\n";
    }

    releaseAll();
    return out;
  }

  private void lockAll() {
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        while(!this.field[i][j].tryAcquire());
  }

  private void releaseAll() {
    for(int i = 0; i < w; i++)
      for(int j = 0; j < h; j++)
        this.field[i][j].release();
  }

}
