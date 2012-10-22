package myunit.color;

public abstract class API {
  abstract public void printSuccess(String msg);
  abstract public void printFailure(String msg);

  public void printTestSuccess(String name) {
    printSuccess("  - " + name + " sucessful");
  }

  public void printTestFailure(String name, String cause) {
    printFailure("  - " + name + " failed: " + cause);
  }
}