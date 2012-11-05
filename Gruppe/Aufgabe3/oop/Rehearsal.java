package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Rehearsal extends Event {
  public Rehearsal(Location location, Date begin, Date end, BigDecimal rent, List<Member> members) { 
    super(location, begin, end, members);
    for(Member m:members)
      m.addProbe(begin);
    payments.add(new Payment("rent", rent.negate(), begin));
  }

  public Rehearsal(String location, Date begin, Date end, BigDecimal rent) { 
    this(new Location(location), begin, end, rent, new ArrayList<Member>());
  }

  public Rehearsal(String location, Date begin, Date end) { 
    this(location, begin, end, new BigDecimal("0"));
  }

  public Rehearsal(Rehearsal r) {
    super(r);
  }

  public BigDecimal getRent() { return getBalance().negate(); }
}