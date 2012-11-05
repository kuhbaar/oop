package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Gig extends Event {
  public Gig(Location loc, Date begin, Date end, BigDecimal payment, List<Member> members) { 
    super(loc, begin, end, members);
    payments.add(new Payment("payment", payment, begin));
  }

  public Gig(String loc, Date begin, Date end, BigDecimal payment) { 
    this(new Location(loc), begin, end, payment, new ArrayList<Member>());
  }

  public Gig(String loc, Date begin, Date end) {
    this(loc, begin, end, new BigDecimal("0"));
  }

  public Gig(Gig g){
    super(g);
  }
  
  public BigDecimal getPayment() { return getBalance(); }
}