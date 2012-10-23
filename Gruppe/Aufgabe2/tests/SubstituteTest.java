package tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;
import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;
import oop.MusicGroup;
import oop.Member;
import oop.Substitute;

// all test classes should extend AbstractTest to get useful utility methods
public class SubstituteTest extends AbstractTest {
  List<String> l;
  Date a, b, c,d;

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
  
    cal.set(2012, 10, 5);
    d = cal.getTime();
  }

 
  @UnitTest
  public void testMemberToSub() {
    MusicGroup g = new MusicGroup("The Goers");
    Member m = new Member("klaus","Moor", "0815", "Chello");
    Member m1= new Member("karl", "koala", "0816", "Guitar");

    g.addMember(m);
    m = g.memberToSub(g.getCurrentMembers().get(0));

    List<Member> l = g.getCurrentMembers();

    for(Member mem : g.getCurrentMembers()) {
      assertTrue(mem instanceof Substitute);
    }

    
  
    
  }
}