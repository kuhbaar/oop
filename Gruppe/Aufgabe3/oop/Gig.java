package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Gig extends Event {
  public Gig(Location loc, Date begin, Date end,List<Member> members) {
    super(loc, begin, end, members);
  }

  public Gig(String loc, Date begin, Date end,List<Member> members) {
    this(new Location(loc), begin, end, members);
  }

  public Gig(Location loc, Date begin, Date end, BigDecimal payment,List<Member> members) { 
    this(loc, begin, end, members);
    payments.add(new Payment("payment", payment, begin));
  }

  public Gig(String loc, Date begin, Date end, BigDecimal payment,List<Member> members) { 
    this(new Location(loc), begin, end, payment, members);
  }

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