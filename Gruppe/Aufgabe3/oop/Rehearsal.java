package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Rehearsal extends Event {
  public Rehearsal(Location location, Date begin, Date end,List<Member> members) { 
    super(location, begin, end, members);
    for(Member m:members){

       m.addProbe(begin);
    }
  }

  public Rehearsal(String location, Date begin, Date end,List<Member> members) { 
    this(new Location(location), begin, end, members);
  }

  public Rehearsal(Location location, Date begin, Date end, BigDecimal rent,List<Member> members) { 
    this(location, begin, end, members);
    payments.add(new Payment("rent", rent.negate(), begin));
  }

  public Rehearsal(String location, Date begin, Date end, BigDecimal rent,List<Member> members) { 
    this(new Location(location), begin, end, rent, members);
  }

  public Rehearsal(Location location, Date begin, Date end) { 
    super(location, begin, end);
    for(Member m : this.getMembers()){

      if (m instanceof Substitute) m.addProbe(begin);
    }
  }

  public Rehearsal(String location, Date begin, Date end) { 
    this(new Location(location), begin, end);
  }

  public Rehearsal(Location location, Date begin, Date end, BigDecimal rent) { 
    this(location, begin, end);
    payments.add(new Payment("rent", rent.negate(), begin));
  }

  public Rehearsal(String location, Date begin, Date end, BigDecimal rent) { 
    this(new Location(location), begin, end, rent);
  }

  public Rehearsal(Rehearsal r) {
    super(r);
  }

  public BigDecimal getRent() { return getBalance(); }
}