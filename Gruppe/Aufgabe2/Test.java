import java.util.ArrayList;
import java.util.List;
import myunit.TestFramework;
import myunit.AbstractTest;


public class Test extends TestFramework{
  public static void main(String[] args) {
    // add classes that contain tests here
    // for info how to create one, check out EventTest.java and SampleTest.java
    List<Class<? extends AbstractTest>> tests = new ArrayList<Class<? extends AbstractTest>>();
    tests.add(tests.EventTest.class);
    tests.add(tests.PlaylistTest.class);
    tests.add(tests.MemberTest.class);

    runTests(tests);
  }
}