package myunit.color;

public class Windows extends API {
  public void printSuccess(String msg) {
    System.out.println(msg);
  }

  public void printFailure(String msg) {
    System.err.println(msg);
  }
}