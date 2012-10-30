package oop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Member implements Timespan{
  protected String name;
  protected String surname;
  protected String phoneno;
  protected String instrument;
  protected Date Join;
  protected Date Leave;
  protected List<Event> message;
  protected Date[] proben;
  private int hashCode;

  /* Initializes a new Member with name, surname, phonenumber and instrument.
    Join Date and Leave Date are being set to Max-Value,
    All lists are empty.
    */
  public Member(String name, String surname, String phoneno, String inst){
    this.name=name;
    this.surname=surname;
    this.phoneno=phoneno;
    this.instrument=inst;
    this.Join=new Date(Long.MAX_VALUE);
    this.Leave=new Date(Long.MAX_VALUE);
    this.message=new ArrayList<Event>();
    this.proben=new Date[3];
    proben[0]=new Date(0);
    proben[1]=new Date(0);
    proben[2]=new Date(0);

  }
  /* Copies Member m as this Member */
  public Member(Member m){
    this(m.name, m.surname, m.phoneno, m.instrument);
    this.Join=m.getBegin();
    this.Leave=m.getEnd();
    this.message=m.getMessage();
    this.proben=m.getProben();
  }
  /* for all the accessors: return / calculate the requested value */
  public String getName(){return name;}
  public String getSurname(){return surname;}
  public String getPhoneNo(){return phoneno;}
  public String getInstrument(){return instrument;}
  public Date getBegin(){return Join;}
  public Date getEnd(){return Leave;}
  public List<Event> getMessage(){return this.message;}
  public Date[] getProben(){return proben;}

  /* returns a copy of this Member with current Date as Leave (doesn't change current Member) */
  public Member leave(){
    Member m = new Member(this);
    m.Leave= new Date();
    return m;
  }
  /* returns a copy of this Member with current Date as Join (doesn't change current Member) */
  public Member join(){
    Member m = new Member(this);
    m.Join=new Date();
    return m;
  }
  /* adds the Event e to the message List */
  public void sendMessage(Event e){
    message.add(e);
  }
  /* Replies to an Event e:
    True: event accepted,
    False: event declined,
    Comment to the decision */
  public void replyMessage(Event e, boolean b,String comment){
    if(b) e.accept(comment);
    else e.decline(comment);
    message.remove(e);
  }
  /* Returns the Member in String as follows: "Member: name surname phonenumber instrument" */
  public String toString(){
    return ("Member: " + name + " " + surname + " " + phoneno + " " + instrument);
  }

  public void addProbe(Date m){
    Date k= new Date();
    int t=0;
    for (int i = 0; i<3;i++){
      if (k.after(proben[i])){
        k=proben[i];
        t=i;
      }
    }
    if(proben[t].before(m))proben[t]=m;
    return;
  }

  public boolean isAvailable(Date d) { return true; }

  /* true iff the other object has the same identifying content and its class
     can be substituted for this one (Member)
  */
  @Override public boolean equals(Object other) {
    if(this == other) return true;
    if(!(other instanceof Member)) return false;
    Member that = (Member) other;
    return this.name.equals(that.name) &&
      this.surname.equals(that.surname) &&
      this.phoneno.equals(that.phoneno) && 
      this.instrument.equals(that.instrument);
  }

  
  /* a.equals(b) implies a.hashCode() == b.hashCode() */
  @Override public int hashCode() {
    if ( hashCode == 0 ) {
      hashCode = name.hashCode() +
        (surname.hashCode() << 4) +
        (phoneno.hashCode() << 7) +
        (instrument.hashCode() << 11);
    }

    return hashCode;
  }
}
