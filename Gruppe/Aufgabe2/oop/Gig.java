package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Gig extends Event {
  public Gig(String ort, Date begin, Date end,  BigDecimal payment) { 
    super(ort, begin, end, payment);
  }
  public Gig(Gig g){
  	super(g);
  }
  public BigDecimal getPayment() { return balance; }
}