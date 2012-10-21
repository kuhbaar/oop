package oop;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class MusicGroup {
  protected String name;
  protected String genre;
  protected List<Event> events;
  protected List<Event> del_events;
  protected List<Member> current_members;
  protected List<Member> members;
  protected List<Song> playlist;
  protected List<Song> current_playlist;
  protected List<Payment> various_payments;
  
  public MusicGroup(String name) {
    this(name, "varied");
  }

  public MusicGroup(String name, String genre) {
    this.name = name;
    this.genre = genre;
    this.events = new ArrayList<Event>();
    this.members = new ArrayList<Member>();
    this.current_members = new ArrayList<Member>();
    this.playlist = new ArrayList<Song>();
    this.current_playlist = new ArrayList<Song>();
    this.various_payments = new ArrayList<Payment>();
  }

  public void addMember(Member m){
    Member mk=new Member(m.join());
    current_members.add(mk);
    members.add(mk);
  }

  public void deleteMember(Member m) {
    current_members.remove(m);
    members.remove(m);
    members.add(m.leave());
  }

  public List<Member> getCurrentMembers() {
    return new ArrayList<Member>(current_members);
  }

  public List<Member> getMembers(Date begin,Date end){
    return elementsBetween(members, begin,end, Member.class);
  }
  
  public void addSong(String name,int duration) {
    addSong(name,duration, new Date());
  }
  
  public void addSong(String name,int duration, Date come) {
    Song s = new Song (name,duration,come);
    current_playlist.add(s);
    playlist.add(s);
  }
  
  public void deleteSong(Song s) {
    current_playlist.remove(s);
    playlist.remove(s);
    playlist.add(s.remove());
  }
  
  public void deleteSong(String name) {
    List<Song> toDelete = new ArrayList<Song>();
    for(Song s : current_playlist)
      if (s.getName().equals(name))
        toDelete.add(s);

    for(Song s : toDelete)
      deleteSong(s);
  }
  
  public List<Song> getCurrentPlaylist() {
    return new ArrayList<Song>(current_playlist);
  }
  public List<Song> getPlaylist(Date begin,Date end) {
    return elementsBetween(playlist,begin,end,Song.class);
  }

  public void newRehearsal(String location, Date begin, Date end, BigDecimal rent) {
    events.add(new Rehearsal(location, begin, end, rent));
  }

  public void newGig(String location, Date begin, Date end, BigDecimal payment) {
    events.add(new Gig(location, begin, end, payment));
  }

  public void newEvent(Event e){
    events.add(e);
  }

  public void deleteEvent(Event e){
    del_events.add(e);
    events.remove(e);
  }

  public void changeEvent(Event e, Event change){
    del_events.add(events.set(events.indexOf(e), change)); // Replaces e with the changed event
  }

  public List<Rehearsal> getRehearsals(Date begin, Date end) {
    return elementsBetween(events, begin, end, Rehearsal.class);
  }

  public List<Gig> getGigs(Date begin, Date end) {
    return elementsBetween(events, begin, end, Gig.class);
  }

  public List<Event> getEvents(Date begin, Date end) {
    return elementsBetween(events, begin, end, Event.class);
  }

  public BigDecimal getCostsForRehearsals(Date begin, Date end){
    return sum(getRehearsals(begin, end));
  }
  public BigDecimal getPaymentForGigs(Date begin, Date end){
    return sum(getGigs(begin, end));
  }
  public BigDecimal getEventBalance(Date begin, Date end){
    return sum(getEvents(begin, end)); 
  }

  public BigDecimal getBalance(Date begin, Date end){
    return getEventBalance(begin, end).add(getVariousPaymentsSum(begin, end));
  }

  public BigDecimal getVariousPaymentsSum(Date begin, Date end) {
    BigDecimal sum = new BigDecimal(0);
    for(Payment p : various_payments)
      if(p.getDate().after(begin) && p.getDate().before(end) ||
         p.getDate().equals(begin) || p.getDate().equals(end))
        sum = sum.add(p.getAmount());
    return sum;
  }

  public void addPayment(String description, String amount) {
    this.addPayment(description, new BigDecimal(amount));
  }

  public void addPayment(String description, BigDecimal amount) {
    this.various_payments.add(new Payment(description, amount));
  }

  //Sum method for calculating the sum of list elements
  protected <T extends Event> BigDecimal sum(List<T> l){
    BigDecimal sum=new BigDecimal(0);
    for(T e: l)
      sum=e.getBalance().add(sum);
    return sum;
  }

  // can be used for members and repertoir too
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