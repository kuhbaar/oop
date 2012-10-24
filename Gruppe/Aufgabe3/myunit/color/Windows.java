package myunit.color;

public class Windows extends API {
  // this would need to use java native api to get color, but we are not allowed
  // to use libraries ...
  public void printSuccess(String msg) {
    System.out.println(msg);
  }

  public void printFailure(String msg) {
    System.err.println(msg);
  }
}