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
    this.del_events = new ArrayList<Event>();
    this.members = new ArrayList<Member>();
    this.current_members = new ArrayList<Member>();
    this.playlist = new ArrayList<Song>();
    this.current_playlist = new ArrayList<Song>();
    this.various_payments = new ArrayList<Payment>();
  }
  /* adds the Member m to the current_members with current date as Join, also adds it to the members*/
  public void addMember(Member m){
    Member mk= m.join();
    current_members.add(mk);
    members.add(mk);
  }

  //deletes the Member from current_members and adds a new Member copying the old
  //returns the Member
  public Member subToMember(Member m) {
    deleteMember(m);
    m=new Member(m);
    addMember(m);
    return m;
  }

  //deletes a Member from current_members and adds a new substitute copying the old Member
  //returns the Substitute
  public Substitute memberToSub(Member m) {
    deleteMember(m);
    Substitute s=new Substitute(m);
    addMember(s);
    return s;
  }
  
  /* deletes the Member m from current_members, also adds the member with current date as Leave to the members */
  public void deleteMember(Member m) {
    current_members.remove(m);
    members.remove(m);
    members.add(m.leave());
  }
  /* returns the copy of current_members */
  public List<Member> getCurrentMembers() {
    return new ArrayList<Member>(current_members);
  }
  /* returns a list of members inbetween begin and end */
  public List<Member> getMembers(Date begin, Date end){
    return elementsBetween(members, begin, end, Member.class);
  }
  
  // adds a new Song, given the name and the duration to playlist and current_playlist at the current date

  public void addSong(String name, int duration) {
    addSong(name,duration, new Date());
  }
  // adds a new Song, given the name and the duration and the date, when it joined
  public void addSong(String name, int duration, Date come) {
    Song s = new Song (name,duration,come);
    current_playlist.add(s);
    playlist.add(s);
  }

  //removes a Song from the current_playlist and the playlist and adds a copy of it, while setting the copies gone to the current date
  public void deleteSong(Song s) {
    current_playlist.remove(s);
    playlist.remove(s);
    playlist.add(s.remove());
  }
  
  // removes all the Songs with the name given from the current_playlist 

  public void deleteSong(String name) {
    List<Song> toDelete = new ArrayList<Song>();
    for(Song s : current_playlist)
      if (s.getName().equals(name))
        toDelete.add(s);

    for(Song s : toDelete)
      deleteSong(s);
  }
  
  //returns a copy of the current_playlist

  public List<Song> getCurrentPlaylist() {
    return new ArrayList<Song>(current_playlist);
  }

  //returns a copy of the playlist, using only Songs active during at least a part of the Timespan between begin and end

  public List<Song> getPlaylist(Date begin,Date end) {
    return elementsBetween(playlist,begin,end,Song.class);
  }

  //adds a new Rehearsal to the Musicgroup, which the current_members are attending

  public void newRehearsal(String location, Date begin, Date end, BigDecimal rent) {
    newRehearsal(location, begin, end, rent,current_members);
  }

   //adds a new Gig to the Musicgroup, which the current_members are attending

  public void newGig(String location, Date begin, Date end, BigDecimal payment) {
    newGig(location, begin, end, payment,current_members);
  }

  //adds a new Rehearsal to the Musicgroup
  //members states which members are attending

  public void newRehearsal(String location, Date begin, Date end, BigDecimal rent, List<Member> members) {
    events.add(new Rehearsal(location, begin, end, rent, members));
    sendMessageToMembers(new Rehearsal(location, begin, end, rent, members));
  }

  //adds a new Gig to the Musicgroup
  //members states which members are attending
  //members of the class Substitute not having been to at least 3 Rehearsals in the last 7 days wont be added


  public void newGig(String location, Date begin, Date end, BigDecimal payment, List<Member> members) {
    
    List<Member> temp=availableMembers(members);

    events.add(new Gig(location, begin, end, payment, temp));
    sendMessageToMembers(new Gig(location, begin, end, payment, temp));
  }

  //returns the available Members for gigs (all members except members of the class substitute, which have not been attending 3 rehearsal within the last 7 days)
  
  public ArrayList<Member> availableMembers(List<Member> members){

    ArrayList<Member> temp= new ArrayList<Member>();
    Date a = new Date();
    for(Member m: members){

      if (m.isAvailable(a)) temp.add(m);
    }
    return temp;
  }
  /* adds the Event e to the Events, Also informs the current_members by sending a message to them*/
  public void newEvent(Event e){
    events.add(e);
    sendMessageToMembers(e);
  }
  /* deletes the Event e from events and adds it to the del_events, Also informs the current_members by sending a message to them*/
  public void deleteEvent(Event e){
    del_events.add(e);
    events.remove(e);
    sendMessageToMembers(e);
  }

  /* swaps the Event e in the events with the changed Event change.
    The unchanged Event e is being saved in Event change for undoChangeEvent(..),
    Also informs the current_members by sending a message to them*/
  public void changeEvent(Event e, Event change){
    /*BAD: object coupling too strong. It would be better to create a new generic class for Stacks and use it for saving and undoing changes*/
    change.save(e);
    events.add(events.indexOf(e), change);
    sendMessageToMembers(change);
  }
  /* Recalls the previous version of Event change and replaces change with it.
    Also informs the current_members by sending a message to them*/
  public void undoChangeEvent(Event change){
    Event undochange= new Event(change.undo());
    events.set(events.indexOf(change),undochange);
    sendMessageToMembers(change);
  }
  /* adds the Event e to message list of Member to for all Member in current_members*/
  public void sendMessageToMembers(Event e){
    for(Member m: current_members){
      m.sendMessage(e);
    }
  }


  /* return all rehearsals between begin and end (inclusive) */
  public List<Rehearsal> getRehearsals(Date begin, Date end) {
    return elementsBetween(events, begin, end, Rehearsal.class);
  }

  /* return all gigs between begin and end (inclusive) */
  public List<Gig> getGigs(Date begin, Date end) {
    return elementsBetween(events, begin, end, Gig.class);
  }

  /* return all events between begin and end (inclusive) */
  public List<Event> getEvents(Date begin, Date end) {
    return elementsBetween(events, begin, end, Event.class);
  }


  /* return the cost of all rehearsals between begin and end (inclusive) */
  public BigDecimal getCostsForRehearsals(Date begin, Date end){
    return sum(getRehearsals(begin, end));
  }

  /* return the payment for all gigs between begin and end (inclusive) */
  public BigDecimal getPaymentForGigs(Date begin, Date end){
    return sum(getGigs(begin, end));
  }

  /* return the totaal balance for all events between begin and end (inclusive) */
  public BigDecimal getEventBalance(Date begin, Date end){
    return sum(getEvents(begin, end)); 
  }

  /* return the total balance for the period from begin to end */
  public BigDecimal getBalance(Date begin, Date end){
    return getBalanceFilteredBy(new DateFilter(begin, end));
  }

  /* return the sum of all payments that pass a filter f
     this deprecates the sum() function and the various getPaymentForXXX 
     functions, which will be removed in subsequent releases 
   */
  public BigDecimal getBalanceFilteredBy(PaymentFilter f) {
    List<Payment> payments = new ArrayList<Payment>(various_payments);
    for(Event e : events)
      payments.addAll(e.getPayments());

    BigDecimal sum = new BigDecimal(0);
    for(Payment p : payments)
      if(f.checkPayment(p))
        sum = sum.add(p.getAmount());
    return sum;
  }

  public BigDecimal getVariousPaymentsSum(Date begin, Date end) {
    return getVariousPaymentsFilteredBy(new DateFilter(begin, end));
  }

  /* return the sum of all payments that don't belong to a specific event and
     pass a filter f
   */
  public BigDecimal getVariousPaymentsFilteredBy(PaymentFilter f) {
    BigDecimal sum = new BigDecimal(0);
    for(Payment p : various_payments)
      if(f.checkPayment(p))
        sum = sum.add(p.getAmount());
    return sum;
  }

  public MusicGroup add(Payment p) {
    this.various_payments.add(new Payment(p));
    return this;
  }

  /* return the total balance of a list of events */
  protected <T extends Event> BigDecimal sum(List<T> l){
    BigDecimal sum=new BigDecimal(0);
    for(T e: l)
      sum=e.getBalance().add(sum);
    return sum;
  }

  /* takes a list of objects that implement Timespan and returns a more specialized 
     new list of type List<cls> that contains all objects whose duration is in 
     the inclusive range [begin, end] (matching endpoints count too) and which 
     are an instance of cls. (thus the more restricted return type)
   */
  protected <T extends Timespan, U extends Timespan> List<U> elementsBetween(List<T> in, Date begin, Date end, Class<U> cls) {
    final List<U> out = new ArrayList<U>();
    for(T e : in)
      if(cls.isInstance(e) && (e.getBegin().after(begin) && e.getBegin().before(end) ||
                               e.getBegin().equals(begin) || 
                               e.getBegin().equals(end) ||
                               e.getEnd().after(begin) && e.getEnd().before(end) ||
                               e.getEnd().equals(end)) ||
                               e.getEnd().equals(begin) ||
                               e.getBegin().before(begin) && e.getEnd().after(end))
        out.add(cls.cast(e));
    return out;
  }
}