/*Less than 5 BADs:
We think the reason we didn't find enoug BADs is that we were aware to avoid strong object coupling and
create strong class cohesion. Moreover the BADs that we have were made "on purpose" due to the time we already
invested in coding (Excercise 2 recommended to spent around 5-6 h on it) - to save time we implemented some functions
in "worse" but quicker way.*/

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