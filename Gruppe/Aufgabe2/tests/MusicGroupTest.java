package tests;


import java.util.Date;
import java.util.Calendar;
import java.math.BigDecimal;

import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeTest;

//import oop.MusicGroup;
//import oop.Member;
import oop.*;

public class MusicGroupTest extends AbstractTest {
  MusicGroup m;
  Date a, b, c;
  Member karl,klaus,josef;
  Event e1,e2,e3,e4;


  // reset values for each test
  @BeforeTest
  public void initializeCommonValues() {
    // provide some common values
    Calendar cal = Calendar.getInstance();
    cal.set(2012, 9, 15);
    a = cal.getTime();

    cal.set(2012, 10, 4);
    b = cal.getTime();

    cal.set(2012, 10, 10);
    c = cal.getTime();

    m = new MusicGroup("rolling stones");
    karl = new Member("karl","gross","0815","Sax");

    m.addMember(karl);

    m.newGig("london", a, b, new BigDecimal("100.0"));
    m.newGig("new york", b, c, new BigDecimal("500.0"));
    m.newRehearsal("paris", b, c, new BigDecimal("40.0"));

    e1= new Gig("london", a, b, new BigDecimal("100.0"));
    e2= new Gig("new york", b, c, new BigDecimal("500.0"));
    e3= new Rehearsal("paris", b, c, new BigDecimal("40.0"));
    e4= new Rehearsal("paris", c, c, new BigDecimal("40.0"));
  }

  @UnitTest
    public void testMessageFunctionality() {
        assertEqual(karl.getMessage().size(),3); //Cecking if messages are being sent,
        karl.replyMessage(e1,true,"Good idea!");
        assertEqual(e1.getAcceptance(),1);//if member can reply to them and if counted correctly
    }

  @UnitTest
  public void testEventChangers() {
    m.deleteEvent(e1);    
    assertEqual(m.getEvents(a,c).size(), 2); //if deleteEvent works properly
    Event temp= new Event(m.getEvents(a, c).get(1));
    m.changeEvent( temp, e4);
    assertEqual(e4, m.getEvents(a, c).get(1));// same for changeEvent
    m.undoChangeEvent(e4);
    assertEqual(m.getEvents(a,c).get(1),temp);//and finally recall deleted Event
  }

  @UnitTest
  public void testPaymentFilters() {
    assertEqual(m.getBalance(a, a), new BigDecimal("100"));
    assertEqual(m.getBalance(a, b), new BigDecimal("560"));
    assertEqual(m.getBalance(b, c), new BigDecimal("460"));
  }

}