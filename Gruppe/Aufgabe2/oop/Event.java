package oop;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Event implements Timespan {
  public Event(Location loc, Date begin, Date end) { 
    this.location = loc;
    this.begin = new Date(begin.getTime());     // yes, date doesn't even have a copy constructor !
    this.end = new Date(end.getTime());
    this.payments = new ArrayList<Payment>();
  }

  public Event(String loc, Date begin, Date end) {
    this(new Location(loc), begin, end);
  }

  public Event(Event e) {
    this(e.location, e.begin, e.end);
    this.payments = new ArrayList<Payment>(e.payments);
  }

  public Event add(Payment p) {
    Event e = new Event(this);
    e.payments.add(p);
    return e;
  }

  public Location getLocation() { return location; } 
  public List<Payment> getPayments() { return new ArrayList<Payment>(this.payments); }
  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }
  public BigDecimal getBalance() { 
    BigDecimal balance = new BigDecimal(0);
    for(Payment p : payments) {
      balance = balance.add(p.getAmount());
    }
    return balance;
  }

  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", 
      location, begin, end, getBalance());
  }
  
  protected Location location;
  protected Date begin;
  protected Date end;
  protected List<Payment> payments;
}
