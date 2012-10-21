package tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;
import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;
import oop.Gig;
import oop.Event;
import oop.Rehearsal;
import oop.MusicGroup;


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
  public void testGigAccessors() {
    Gig e = new Gig("wien", a, b, new BigDecimal("100.10"));
    assertEqual(e.getLocation().toString(), "wien");
    assertEqual(e.getBegin(), a);
    assertEqual(e.getEnd(), b);
    assertEqual(e.getPayment(), new BigDecimal("100.10"));
  }

  @UnitTest
  public void testClassRelationship() {
    Gig auf = new Gig("wien", a, b, new BigDecimal("100.10"));
    Rehearsal prb = new Rehearsal("tirol", b, c, new BigDecimal("20.16"));

    assertIsInstance(auf, Event.class);
    assertIsInstance(prb, Event.class);
  }

  @UnitTest
  public void testMusikgruppeEventGetters() {
    MusicGroup m = new MusicGroup("Bremer Stadtmusikanten");

    m.newGig("wien", a, b, new BigDecimal("100.10"));
    m.newGig("salzburg", a, b, new BigDecimal("500.0"));
    m.newRehearsal("tirol", b, c, new BigDecimal("20.16"));

    List<Rehearsal> ps = m.getRehearsals(a, c);
    assertEqual(ps.size(), 1);
    assertEqual(ps.get(0).getLocation().toString(), "tirol");

    assertEqual(m.getGigs(a, c).size(), 2);
    assertEqual(m.getEvents(a, c).size(), 3);

    assertEqual(m.getEvents(b, c).size(), 1);
    assertEqual(m.getEvents(a, b).size(), 2);
  }

  @UnitTest
  public void testCostSums() {
    MusicGroup m = new MusicGroup("U2");

    m.newGig("wien", a, b, new BigDecimal("100.10"));
    m.newGig("salzburg", b, c, new BigDecimal("500.0"));
    m.newRehearsal("tirol", b, c, new BigDecimal("20.16"));

    assertEqual(new BigDecimal("-20.16"), m.getCostsForRehearsals(a, c));
    assertEqual(new BigDecimal("600.1"), m.getPaymentForGigs(a, c));
    assertEqual(new BigDecimal("479.84"), m.getBalance(c, c));
  }
}
