import java.util.concurrent.Semaphore;

public class Cell {
  Semaphore s;
  Maybe<Car> car;


  public Cell() {
    this.s = new Semaphore(1);
    this.car = new None<Car>();
  }

  /*if not locked acquires this cell and returns true if it worked*/
  public boolean tryAcquire() {
    return this.s.tryAcquire();
  }

  public void release() {
    this.s.release();
  }

  public void removeCar() {
    this.car = new None<Car>();
  }

  /*adds a car to this cell
  cell cannot have another car already*/
  public void addCar(Car c) {
    assert(!hasCar());
    this.car = new Some<Car>(c);
  }

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

  /*returns a String of a single char pointing in the direction the car is aligned*/
  @Override public String toString() {
    if(car.isDefined())
      return car.get().toString();
    else
      return ".";
  }
}
