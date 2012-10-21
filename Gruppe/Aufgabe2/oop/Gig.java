package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Gig extends Event {
  public Gig(String loc, Date begin, Date end,  BigDecimal payment) { 
    super(loc, begin, end, payment);
  }

  public Gig(Location loc, Date begin, Date end,  BigDecimal payment) { 
    super(loc, begin, end, payment);
  }

  public Gig(Gig g){
  	super(g);
  }
  
  public BigDecimal getPayment() { return balance; }
}