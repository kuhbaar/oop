package myunit.color;

public abstract class API {
  /* GOOD: printSuccess(String) and printFailure(String) will be implemented by
     concrete classes specialized by operating system. This allows hiding of
     implementation details (= ugly windows color api) and implementation of 
     mightier helper functions in one place (eg printTestSuccess(String) below)
   */
  abstract public void printSuccess(String msg);
  abstract public void printFailure(String msg);

  /* print a success message formated in a positive way (green if supported by
     platform) */
  public void printTestSuccess(String name) {
    printSuccess("  - " + name + " sucessful");
  }

  /* print a failure message formated in a negative way (red if supported by
     platform), with an explanation of why the test failed */
  public void printTestFailure(String name, String cause) {
    printFailure("  - " + name + " failed: " + cause);
  }
}