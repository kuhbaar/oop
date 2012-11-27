public class Actor {
  private final String name;
  private final double power;

  public Actor(String name, double power) {
    this.name = name;
    this.power = power;
  }
  
  public double getPower() {
    return this.power;
  }
}