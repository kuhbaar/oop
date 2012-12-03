import java.util.concurrent.Semaphore;

public class Cell {
  Semaphore s;
  Maybe<Car> car;

  public Cell() {
    this.s = new Semaphore(1);
    this.car = new None<Car>();
  }

  public boolean tryAcquire() {
    return this.s.tryAcquire();
  }

  public void release() {
    this.s.release();
  }

  public void removeCar() {
    this.car = new None<Car>();
  }

  public void addCar(Car c) {
    assert(!hasCar());
    this.car = new Some<Car>(c);
  }

  public boolean hasCar() {
    return car.isDefined();
  }

  @Override public String toString() {
    if(car.isDefined())
      return car.get().toString();
    else
      return ".";
  }
}
