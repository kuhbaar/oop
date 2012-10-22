package oop;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Stack;

public class Event implements Timespan {
  public Event(Location loc, Date begin, Date end) { 
    this.location = loc;
    this.begin = new Date(begin.getTime());     // yes, date doesn't even have a copy constructor !
    this.end = new Date(end.getTime());
    this.payments = new ArrayList<Payment>();
    this.change = new Stack<Event>();
    this.accepted=0;
    this.declined=0;
  }

  public Event(String loc, Date begin, Date end) {
    this(new Location(loc), begin, end);
  }

  public Event(Event e) {
    this(e.location, e.begin, e.end);
    this.payments = new ArrayList<Payment>(e.payments);
    this.accepted = e.getAcceptance();
    this.declined = e.getDeclination();
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
  public Stack<Event> getChange() { return change;}
  public BigDecimal getBalance() { 
    BigDecimal balance = new BigDecimal(0);
    for(Payment p : payments) {
      balance = balance.add(p.getAmount());
    }
    return balance;
  }
  public int getAcceptance(){ return accepted;}
  public int getDeclination(){ return declined;}

  public void save(Event e){
    this.change.push(e);
  }

  public Event undo(){
    Event e=new Event(this.change.pop());
    return e;
  }
  
  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", 
      location, begin, end, getBalance());
  }

  public void accept(String comment) {
   accepted++; 
  }
  public void decline(String comment) {
   declined++;
  }
  
  protected Location location;
  protected Date begin;
  protected Date end;
  protected Stack<Event> change;
  protected List<Payment> payments;
  protected int accepted;
  protected int declined;
}

