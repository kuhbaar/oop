package oop;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Stack;

/* an event that happens at give time at some location, with members and payments */
public class Event implements Timespan {

  //contstructs a new Event including a given MemberList
  public Event(Location loc, Date begin, Date end, List<Member> members) { 
    this.location = loc;
    this.begin = new Date(begin.getTime()); 
    this.end = new Date(end.getTime());
    this.payments = new ArrayList<Payment>();
    this.change = new Stack<Event>();
    this.accepted=0;
    this.declined=0;
    this.members= new ArrayList<Member>(members);
  }

  //constructs a new Event without given MemberList, therefor using a new and empty MemberList
  public Event(String loc, Date begin, Date end) {
    this(new Location(loc), begin, end, new ArrayList<Member>());
  }

  //constructs a new Event by copying the values used by the given Event
  public Event(Event e) {
    this(e.location, e.begin, e.end, e.members);
    this.payments = e.getPayments();
    this.accepted = e.getAcceptance();
    this.declined = e.getDeclination();
  }

  /* returns a new Event with the payment added, without modifying this event */
  public Event add(Payment p) {
    Event e = new Event(this);
    e.payments.add(p);
    return e;
  }

  /* for all the accessors: return / calculate the requested value */
  public Location getLocation() { return location; } 
  public List<Payment> getPayments() { return new ArrayList<Payment>(this.payments); }
  public Date getBegin() { return new Date(begin.getTime()); }
  public Date getEnd() { return new Date(end.getTime()); }
  public Stack<Event> getChange() { return change;}
  public List<Member> getMembers(){ return new ArrayList<Member>(members); }
  public BigDecimal getBalance() { 
    BigDecimal balance = new BigDecimal(0);
    for(Payment p : payments) {
      balance = balance.add(p.getAmount());
    }
    return balance;
  }
  public int getAcceptance(){ return accepted;}
  public int getDeclination(){ return declined;}

  /* BAD: undo-functionality could be separated from this class and provided by
   * a generic class. */
  /* saves the Event e to the change-Stack*/
  public void save(Event e){
    this.change.push(e);
  }
  /* returns the first Event from the change-Stack and removes it from the Stack */
  public Event undo(){
    Event e=new Event(this.change.pop());
    return e;
  }
  
  public String toString() {
    return String.format("Event in %s von %s bis %s, %s $", 
      location, begin, end, getBalance());
  }

  /* BAD: acceptance and comments could be handled by a separate class, so they
   * wouldn't have to modify the internal state of events 
   */ 
  /* adds +1 to the accepted-integer of this Event every time this method is called */
  public void accept(String comment) {
   accepted++; 
  }
  /* adds +1 to the declined-integer of this Event every time this method is called */
  public void decline(String comment) {
   declined++;
  }


  /* true iff the other object has the same identifying content and its class
     can be substituted for this one (Event)
   */
  @Override public boolean equals(Object other) {
    if(this == other) return true;
    if(!(other instanceof Event)) return false;
    Event that = (Event) other;
    return this.location.equals(that.location) &&
      this.begin.equals(that.begin) &&
      this.end.equals(that.end);
  }

  /* a.equals(b) implies a.hashCode() == b.hashCode() */
  @Override public int hashCode() {
    if ( hashCode == 0 ) {
      hashCode = location.hashCode() +
        (begin.hashCode() << 4) +
        (end.hashCode() << 7);
    }
    return hashCode;
  }
  
  private final Location location;
  private final Date begin;
  private final Date end;
  private final Stack<Event> change;
  private final List<Member> members;
  private int accepted;
  private int declined;
  private int hashCode;


  // protected, so subclasses can modify it on creation
  protected List<Payment> payments;
}

