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

//tests the Methods which are concerning Substitutes

public class SubstituteTest extends AbstractTest {
  List<String> l;
  Date mon, tue, wed, thu, fri, sat, sun;

  @BeforeClass
  public void initializeCommonValues() {
    Calendar cal = Calendar.getInstance();
    

    cal.set(2012, 9, 22);
    mon = cal.getTime();

    cal.set(2012, 9, 23);
    tue = cal.getTime();

    cal.set(2012, 9, 24);
    wed = cal.getTime();

    cal.set(2012, 9, 25);
    thu = cal.getTime();

    cal.set(2012, 9, 26);
    fri = cal.getTime();

    cal.set(2012, 9, 27);
    sat = cal.getTime();

    cal.set(2012, 9, 28);
    sun = cal.getTime();
  }

 
  //tests the methods memberToSub() and subToMember in MusicGroup, returns true if both work

  @UnitTest
  public void testChangeType() {
    MusicGroup g = new MusicGroup("The Goers");
    Member m = new Member("klaus","Moor", "0815", "Chello");
    Member m1= new Member("karl", "koala", "0816", "Guitar");

    g.addMember(m);
    m = g.memberToSub(m);

    List<Member> l = g.getCurrentMembers();

    //the current_Member List has to contain only objects of the type Substitute
    for(Member mem : g.getCurrentMembers()) {
      assertTrue(mem instanceof Substitute);
    }

    g.subToMember(m);
    //current_Member List has to contain only Member, which are not of the type Substitute
    for(Member mem : g.getCurrentMembers()) {
      assertTrue(!(mem instanceof Substitute));
    }
  }

  //tests the addProbe Method in Member

  @UnitTest
  public void testIsAvailable() {
    MusicGroup g = new MusicGroup("The Goers");
    Member m = new Member("klaus","Moor", "0815", "Chello");
    Member m1= new Member("karl", "koala", "0816", "Guitar");

    g.addMember(m);
    m = g.memberToSub(m);

    List<Member> l = g.getCurrentMembers();


    //since the proben[] is empty the Substitutes should not be available 

    for(Member mem : g.getCurrentMembers()) {
      assertTrue(!(mem.isAvailable(thu)));
    }

    g.newRehearsal("tirol", mon, tue, new BigDecimal("20.16"));
    g.newRehearsal("tirol", tue, wed, new BigDecimal("20.16"));
    g.newRehearsal("tirol", wed, thu, new BigDecimal("20.16"));

    //the Substitutes should now be available since 3 new Rehearsals have been added

    for(Member mem : g.getCurrentMembers()) {
      System.out.println("test");

      //all Dates of proben in mem have to be within 7 days of thu
      assertTrue(mem.isAvailable(thu));
      //checks whether isAvailable works correctly within 7 days and not just any timespan
      assertTrue(!(mem.isAvailable(new Date(Long.MAX_VALUE))));
    }

    
  }


}