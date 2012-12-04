import java.util.concurrent.Semaphore;

public class Cell {
  Semaphore s;
  Maybe<Car> car;


  /* creates a new cell, initially unlocked and without a car */
  public Cell() {
    this.s = new Semaphore(1);
    this.car = new None<Car>();
  }

  /* try to lock this cell - returns true if it succeeded, false otherwise */
  public boolean tryAcquire() {
    return this.s.tryAcquire();
  }

  /* release the lock again */
  public void release() {
    this.s.release();
  }

  /* remove the car from this cell */
  public void removeCar() {
    this.car = new None<Car>();
  }

  /* adds a car to this cell
  cell cannot have another car already*/
  public void addCar(Car c) {
    assert(!hasCar());
    this.car = new Some<Car>(c);
  }

  /* true if the cell has a car, false otherwise */
  public boolean hasCar() {
    return car.isDefined();
  }

  /*used to notify a car it got hit*/
  public void gotHit(AbsoluteDirection d) {
    if(hasCar())
      this.car.get().gotHit(d);
  }

  /*returns a string containing cartype, AItype and name of the car currently in this cell
  if there is none returns "empty"*/
  public String getDescription() {
    if(car.isDefined())
      return car.get().getDescription();
    else
      return "empty";
  }

  /*returns a String of a single char pointing in the direction the car is aligned
    if there is no car, simply returns "." */
  @Override public String toString() {
    if(car.isDefined())
      return car.get().toString();
    else
      return ".";
  }
}
