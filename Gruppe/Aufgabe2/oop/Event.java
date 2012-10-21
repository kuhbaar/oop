package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Event implements Timespan {
  public Event(String loc, Date begin, Date end, BigDecimal balance) {
    this(new Location(loc), begin, end, balance);
  }

  public Event(Location loc, Date begin, Date end, BigDecimal balance) { 
    this.location = loc;
    this.begin = begin;
    this.end = end;
    this.balance = balance;
  }
      
  public Event(Event e){
    this.location=e.getLocation();
    this.begin=e.getBegin();
    this.end=e.getEnd();
    this.balance=e.getBalance();
  }

  public Location getLocation() { return location; } 
  public BigDecimal getBalance() { return balance; }
  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }

  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", location, begin, end, balance);
  }
  
  protected Location location;
  protected Date begin;
  protected Date end;
  protected BigDecimal balance;
}
