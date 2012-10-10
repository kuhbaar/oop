import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;

// all test classes should extend AbstractTest to get useful utility methods
public class EventTest extends AbstractTest {
  List<String> l;
  Date a, b, c;

  @BeforeClass
  public void initializeCommonValues() {
    // provide some common values
    Calendar cal = Calendar.getInstance();
    cal.set(2012, 9, 15);
    a = cal.getTime();

    cal.set(2012, 10, 4);
    b = cal.getTime();

    cal.set(2012, 10, 10);
    c = cal.getTime();
  }

  @UnitTest
  public void testAuftrittAccessors() {
    Auftritt e = new Auftritt("wien", a, b, new BigDecimal("100.10"));
    assertEqual(e.getOrt(), "wien");
    assertEqual(e.getBegin(), a);
    assertEqual(e.getEnd(), b);
    assertEqual(e.getGage(), new BigDecimal("100.10"));
  }

  @UnitTest
  public void testClassRelationship() {
    Auftritt auf = new Auftritt("wien", a, b, new BigDecimal("100.10"));
    Probe prb = new Probe("tirol", b, c, new BigDecimal("20.16"));

    assertIsInstance(auf, Event.class);
    assertIsInstance(prb, Event.class);

  }

}