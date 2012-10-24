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
import oop.Payment;


// all test classes should extend AbstractTest to get useful utility methods
public class EventTest extends AbstractTest {
  List<String> l;
  Date mon, tue, wed, thu, fri, sat, sun;

  @BeforeClass
  public void initializeCommonValues() {
    // provide some common values
    Calendar cal = Calendar.getInstance();
    cal.set(2012, 9, 15);
    mon = cal.getTime();

    cal.set(2012, 9, 16);
    tue = cal.getTime();

    cal.set(2012, 9, 17);
    wed = cal.getTime();

    cal.set(2012, 9, 18);
    thu = cal.getTime();

    cal.set(2012, 9, 19);
    fri = cal.getTime();

    cal.set(2012, 9, 20);
    sat = cal.getTime();

    cal.set(2012, 9, 21);
    sun = cal.getTime();
  }

  @UnitTest
  public void testGigAccessors() {
    Gig e = new Gig("wien", mon, tue, new BigDecimal("100.10"));
    assertEqual(e.getLocation().toString(), "wien");
    assertEqual(e.getBegin(), mon);
    assertEqual(e.getEnd(), tue);
    assertEqual(e.getPayment(), new BigDecimal("100.10"));
  }

  @UnitTest
  public void testClassRelationship() {
    Gig auf = new Gig("wien", mon, tue, new BigDecimal("100.10"));
    Rehearsal prb = new Rehearsal("tirol", tue, wed, new BigDecimal("20.16"));

    assertIsInstance(auf, Event.class);
    assertIsInstance(prb, Event.class);
  }

  @UnitTest
  public void testMusikgruppeEventGetters() {
    MusicGroup m = new MusicGroup("Bremer Stadtmusikanten");

    m.newGig("wien", mon, tue, new BigDecimal("100.10"));
    m.newGig("salzburg", wed, thu, new BigDecimal("500.0"));
    m.newRehearsal("tirol", fri, sat, new BigDecimal("20.16"));

    List<Rehearsal> ps = m.getRehearsals(mon, sun);
    assertEqual(ps.size(), 1);
    assertEqual(ps.get(0).getLocation().toString(), "tirol");

    assertEqual(m.getGigs(mon, fri).size(), 2);
    assertEqual(m.getGigs(wed, fri).size(), 1);
    assertEqual(m.getEvents(mon, sun).size(), 3);

    assertEqual(m.getEvents(fri, sun).size(), 1);
    assertEqual(m.getEvents(thu, sun).size(), 2);
  }

  @UnitTest
  public void testCostSums() {
    MusicGroup m = new MusicGroup("U2");

    m.newGig("wien", mon, tue, new BigDecimal("100.10"));
    m.newGig("salzburg", tue, wed, new BigDecimal("500.0"));
    m.newRehearsal("tirol", tue, wed, new BigDecimal("20.16"));

    assertEqual(new BigDecimal("-20.16"), m.getCostsForRehearsals(mon, sun));
    assertEqual(new BigDecimal("600.1"), m.getPaymentForGigs(mon, sun));
    assertEqual(new BigDecimal("479.84"), m.getEventBalance(wed, fri));
  }

  @UnitTest
  public void testMultiplePayments() {
    Event g = new Gig("melk", mon, tue)
      .add(new Payment("gage", "500"))
      .add(new Payment("verpflegung", "-100"));

    assertEqual(new BigDecimal("400"), g.getBalance());
  }


  @UnitTest
  public void testVariousPaymentSum() {
    MusicGroup m = new MusicGroup("U2");

    m.newGig("wien", mon, tue, new BigDecimal("100.10"));
    m.newGig("salzburg", tue, wed, new BigDecimal("500.0"));
    m.newRehearsal("tirol", tue, wed, new BigDecimal("20.16"));
    m.add(new Payment("bonus", "100", mon));

    assertEqual(new BigDecimal("100"), m.getVariousPaymentsSum(mon, tue));
    assertEqual(new BigDecimal("0"), m.getVariousPaymentsSum(fri, sun));
    assertEqual(new BigDecimal("679.94"), m.getBalance(mon, sun));
  }


    @UnitTest
    public void equalityTests() {
      String s = new String("wien");
      Event e1 = new Event("wien", mon, tue);
      Event e2 = new Event(s, mon, tue);
      Event e3 = new Gig("wien", mon, tue);

      assertEqual(e1, e2);
      assertEqual(e2, e3);
      assertEqual(e1, e3);

    }
}
