package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Gig extends Event {
  public Gig(Location loc, Date begin, Date end) {
    super(loc, begin, end);
  }

  public Gig(String loc, Date begin, Date end) {
    this(new Location(loc), begin, end);
  }

  public Gig(Location loc, Date begin, Date end, BigDecimal payment) { 
    this(loc, begin, end);
    payments.add(new Payment("payment", payment, begin));
  }

  public Gig(String loc, Date begin, Date end, BigDecimal payment) { 
    this(new Location(loc), begin, end, payment);
  }

  public Gig(Gig g){
  	super(g);
  }
  
  public BigDecimal getPayment() { return getBalance(); }
}