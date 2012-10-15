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

  @UnitTest
  public void testMusikgruppeEventGetters() {
    Musikgruppe m = new Musikgruppe();

    m.newAuftritt("wien", a, b, new BigDecimal("100.10"));
    m.newAuftritt("salzburg", a, b, new BigDecimal("500.0"));
    m.newProbe("tirol", b, c, new BigDecimal("20.16"));

    List<Probe> ps = m.getProben(a, c);
    assertEqual(ps.size(), 1);
    assertEqual(ps.get(0).getOrt(), "tirol");

    assertEqual(m.getAuftritte(a, c).size(), 2);
    assertEqual(m.getEvents(a, c).size(), 3);

    assertEqual(m.getEvents(b, c).size(), 1);
    assertEqual(m.getEvents(a, b).size(), 2);
  }

  @UnitTest
  public void testCostSums() {
    Musikgruppe m = new Musikgruppe();

    m.newAuftritt("wien", a, b, new BigDecimal("100.10"));
    m.newAuftritt("salzburg", b, c, new BigDecimal("500.0"));
    m.newProbe("tirol", b, c, new BigDecimal("20.16"));

    assertEqual(new BigDecimal("-20.16"), m.getCostsProben(a, c));
    assertEqual(new BigDecimal("600.1"), m.getGageAuftritte(a, c));
    assertEqual(new BigDecimal("479.84"), m.getCostsEvents(c, c));

  }

}