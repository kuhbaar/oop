import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.Duration;
import java.math.BigDecimal;

public class Musikgruppe {
  protected List<Event> events;
  protected List<Member> members;
  protected List<Member> oldmemb;

  Musikgruppe() {
    this.events = new ArrayList<Event>();
    this.members = new ArrayList<Member>();
  }
  public void addMember(String name,String surname,BigDecimal number,String instr){
    members.add(new Member(name,surname,number,instr));
  }
  public void delMember(Member m){
    members.remove(m);
    oldmemb.add(m.leave());
  }
  public List<Member> getMembers(){
    return members;
  }
  public List<Member> getMembers(Date begin,Date end){
    return elementsBetween(oldmemb,begin,end,Member.class);
  }

  public void newProbe(String ort, Date begin, Date end,  BigDecimal raummiete) {
    events.add(new Probe(ort, begin, end, raummiete));
  }

  public void newAuftritt(String ort, Date begin, Date end, BigDecimal gage) {
    events.add(new Auftritt(ort, begin, end, gage));
  }

  public List<Probe> getProben(Date begin, Date end) {
    return elementsBetween(events, begin, end, Probe.class);
  }

  public List<Auftritt> getAuftritte(Date begin, Date end) {
    return elementsBetween(events, begin, end, Auftritt.class);
  }

  public List<Event> getEvents(Date begin, Date end) {
    return elementsBetween(events, begin, end, Event.class);
  }

  public BigDecimal getCostsProben(Date begin, Date end){
    return sum(getProben(begin, end));
  }
  public BigDecimal getGageAuftritte(Date begin, Date end){
    return sum(getAuftritte(begin, end));
  }
  public BigDecimal getCostsEvents(Date begin, Date end){
    return sum(getEvents(begin, end)); 
  }

  //Sum method for calculating the sum of list elements
  protected <T extends Event> BigDecimal sum(List<T> l){
    BigDecimal sum=new BigDecimal(0);
    for(T e: l)
      sum=e.getBalance().add(sum);
    return sum;
  }

  // can be used for mitglieder and repertoir too
  // some template trickery to make it return a List of the requested type, not
  // the common supertype
  protected <T extends Timespan, U extends Timespan> List<U> elementsBetween(List<T> in, Date begin, Date end, Class<U> cls) {
    final List<U> out = new ArrayList<U>();
    for(T e : in)
      if(cls.isInstance(e) && (e.getBegin().after(begin) && e.getBegin().before(begin) ||
                               e.getBegin().equals(begin) ||  // before and after are > and <, so we need == too
                               e.getEnd().after(begin) && e.getEnd().before(end) ||
                               e.getEnd().equals(end)))
        out.add(cls.cast(e));
    return out;
  }
}