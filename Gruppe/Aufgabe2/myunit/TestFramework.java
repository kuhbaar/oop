package myunit;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import myunit.color.API;
import myunit.color.Ansi;

public class TestFramework {
  public static String getLocation(Throwable t, int depth) {
    StackTraceElement l = t.getStackTrace()[depth];
    return "line "+l.getLineNumber();
  }

  public static void runTests(List<Class<? extends AbstractTest>> cs) {
    API colorizer = new Ansi();
    System.out.println(System.getProperty("os.name"));
    try {
      // Windows uses non-portable system calls, so we have to load it dynamically
      if(System.getProperty("os.name").startsWith("Windows"))
        colorizer = (API) Class.forName("myunit.color.Windows").newInstance();
    } catch(Exception e) {
      System.out.println("failed to load colorizer");
      e.printStackTrace();
    }

    int failed_tests = 0;
    int total_tests = 0;

    for(Class<? extends AbstractTest> cls : cs) {
      try {
        Object o = cls.newInstance();
        System.out.println("Testing " + cls.getName());

        // run all setup methods
        for(Method m : cls.getDeclaredMethods())
          if(m.isAnnotationPresent(BeforeClass.class))
            m.invoke(o);
        
        // run all test methods
        for(Method m : cls.getDeclaredMethods()) {
          if(m.isAnnotationPresent(UnitTest.class)) {
            total_tests += 1;
            // method declared as unittest

            // run all test call setup methods
            for(Method setup : cls.getDeclaredMethods())
              if(setup.isAnnotationPresent(BeforeTest.class))
                setup.invoke(o);

            try {
              m.invoke(o);
              if(m.isAnnotationPresent(AssertThrows.class)) {
                colorizer.printTestFailure(m.getName(), "excpected Exception wasn't thrown: " +
                  m.getAnnotation(AssertThrows.class).exception());
              } else {
                colorizer.printTestSuccess(m.getName());
              }
            } catch(InvocationTargetException e) {
              if(e.getCause() instanceof AssertException) {
                colorizer.printTestFailure(m.getName(), e.getCause().getMessage()+ 
                    " @ " + getLocation(e.getCause(), 1));
                failed_tests += 1;
              } else {
                // methods just threw an exception that wasn't from assert
                // check if that was to be excpected
                if(m.isAnnotationPresent(AssertThrows.class) &&
                  m.getAnnotation(AssertThrows.class).exception().equals(e.getCause().getClass())) {
                  colorizer.printTestSuccess(m.getName());
                } else {
                  failed_tests += 1;
                  colorizer.printTestFailure(m.getName(), 
                    "unexpected Exception: ");
                  e.getCause().printStackTrace();
                }
              }
            } 
          }
        }
      } catch(Exception e) {
        colorizer.printFailure("failed to run tests for class " + cls.getName());
        e.printStackTrace();
      }
    }

    if(failed_tests == 0) {
      System.out.println();
      colorizer.printSuccess("all tests sucessful!");
    } else {
      System.out.println();
      colorizer.printFailure(String.format("%d / %d failed!", failed_tests, total_tests));
      System.exit(1);
    }
  }
}