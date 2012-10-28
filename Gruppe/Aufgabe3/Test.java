import java.util.ArrayList;
import java.util.List;
import myunit.TestFramework;
import myunit.AbstractTest;


public class Test extends TestFramework{
  public static void main(String[] args) {
    List<Class<? extends AbstractTest>> tests = new ArrayList<Class<? extends AbstractTest>>();
    tests.add(tests.EventTest.class);
    tests.add(tests.PlaylistTest.class);
    tests.add(tests.MemberTest.class);
    tests.add(tests.InfrastructureTest.class);
    tests.add(tests.MusicGroupTest.class);
    tests.add(tests.SubstituteTest.class);

    runTests(tests);
  }
}