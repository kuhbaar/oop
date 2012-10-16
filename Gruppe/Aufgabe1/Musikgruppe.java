import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.Duration;
import java.math.BigDecimal;

public class Musikgruppe {
  protected List<Event> events;
  protected List<Member> current_members;
  protected List<Member> members;
  protected List<Song> playlist;
  protected List<Song> current_playlist;
  
  
  Musikgruppe() {
    this.events = new ArrayList<Event>();
    this.members = new ArrayList<Member>();
	this.current_members = new ArrayList<Member>();
	this.playlist = new ArrayList<Song>();
	this.current_playlist = new ArrayList<Song>();
  }
  public void addMember(String name,String surname,BigDecimal number,String instr){
	Member m = new Member(name,surname,number,instr);
    current_members.add(m);
	members.add(m);
  }
  public void deleteMember(Member m){
    current_members.remove(m);
    members.remove(m);
    members.add(m.leave());
  }
  public List<Member> getCurrentMembers(){
    return new ArrayList<Member>(current_members);
  }
  public List<Member> getMembers(Date begin,Date end){
    return elementsBetween(members, begin,end, Member.class);
  }
  
  public void addSong(String name,int duration){
	addSong(name,duration, new Date());
  }
  
   public void addSong(String name,int duration, Date come){
	Song s = new Song (name,duration,come);
    current_playlist.add(s);
	playlist.add(s);
  }
  
  public void deleteSong(Song s){
    current_playlist.remove(s);
    playlist.remove(s);
    playlist.add(s.remove());
  }
  
  public void deleteSong(String name){
	for(Song s: playlist){
		if (s.getName().equals(name)){
			playlist.remove(s);
			current_playlist.remove(s);
			playlist.add(s.remove());
		}
	}
	
  }
  
  public List<Song> getCurrentPlaylist(){
    return new ArrayList<Song>(current_playlist);
  }
  public List<Song> getPlaylist(Date begin,Date end){
    return elementsBetween(playlist,begin,end,Song.class);
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
      if(cls.isInstance(e) && (e.getBegin().after(begin) && e.getBegin().before(end) ||
                               e.getBegin().equals(begin) ||  // before and after are > and <, so we need == too
                               e.getEnd().after(begin) && e.getEnd().before(end) ||
                               e.getEnd().equals(end)) ||
							   e.getBegin().before(begin) && e.getEnd().after(end))
        out.add(cls.cast(e));
    return out;
  }
}