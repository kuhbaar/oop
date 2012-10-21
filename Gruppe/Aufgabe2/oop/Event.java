package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Event implements Timespan {
  public Event(String location, Date begin, Date end, BigDecimal balance) { 
    this.location = location;
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

  public String getLocation() { return location; }       
  public BigDecimal getBalance() { return balance; }
  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }

  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", location, begin, end, balance);
  }

  protected String location;
  protected Date begin;
  protected Date end;
  protected BigDecimal balance;
}
