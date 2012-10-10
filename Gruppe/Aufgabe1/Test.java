import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class Test {
  public static void main(String[] args) {
    // add classes that contain tests here
    runTest(SampleTest.class);
  }

  /***************************************
   *           don't edit below          *
   **************************************/

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  static void printSuccess(String name) {
    System.out.println(ANSI_GREEN + "  - " + name + " sucessful" + ANSI_RESET);
  }

  static void printFailure(String name, String cause) {
    System.out.println(ANSI_RED + "  - " + name + " failed: " + cause + ANSI_RESET);
  }

  static void runTest(Class cls) {
    try {
      Object o = cls.newInstance();
      System.out.println("Testing " + cls.getName());

      for(Method m : cls.getDeclaredMethods()) {
        if(m.getAnnotation(UnitTest.class) != null) {
          // method declared as unittest
          try {
            m.invoke(o);
            printSuccess(m.getName());
          } catch(InvocationTargetException e) {
            printFailure(m.getName(), e.getCause().getMessage());
          }
        }
      }
    } catch(Exception e) {
      System.out.println("failed to run tests for class " + cls.getName());
      e.printStackTrace();
    }
  }
}