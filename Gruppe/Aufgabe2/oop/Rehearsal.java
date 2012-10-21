package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Rehearsal extends Event {
  public Rehearsal(Location location, Date begin, Date end) { 
    super(location, begin, end);
  }

  public Rehearsal(String location, Date begin, Date end) { 
    this(new Location(location), begin, end);
  }

  public Rehearsal(Location location, Date begin, Date end, BigDecimal rent) { 
    this(location, begin, end);
    payments.add(new Payment("rent", rent.negate()));
  }

  public Rehearsal(String location, Date begin, Date end, BigDecimal rent) { 
    this(new Location(location), begin, end, rent);
  }

  public Rehearsal(Rehearsal r) {
  	super(r);
  }

  public BigDecimal getRent() { return getBalance(); }
}