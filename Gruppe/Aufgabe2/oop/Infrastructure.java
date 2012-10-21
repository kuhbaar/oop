package oop;

public class Infrastructure {
  public Infrastructure(String description) {
    this.description = description;
  }
  
  public Boolean provides(Infrastructure i) {
    return false;
  }

  protected String description;
}