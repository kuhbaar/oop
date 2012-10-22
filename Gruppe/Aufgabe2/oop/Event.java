package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.Stack;

public class Event implements Timespan {
  public Event(String location, Date begin, Date end, BigDecimal balance) { 
    this.location = location;
    this.begin = begin;
    this.end = end;
    this.balance = balance;
    this.change = new Stack<Event>();
  }

  public Event(Event e){
    this.location=e.getLocation();
    this.begin=e.getBegin();
    this.end=e.getEnd();
    this.balance=e.getBalance();
    this.change=e.getChange();
  }

  public String getLocation() { return location; }       
  public BigDecimal getBalance() { return balance; }
  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }
  public Stack<Event> getChange() { return change;}

  public void save(Event e){
    this.change.push(e);
  }

  public Event undo(){
    Event e=new Event(this.change.pop());
    return e;
  }
  
  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", location, begin, end, balance);
  }

  protected String location;
  protected Date begin;
  protected Date end;
  protected BigDecimal balance;
  protected Stack<Event> change;
}