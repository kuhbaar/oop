import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.Duration;

public class Musikgruppe {
  protected List<Event> events;

  Musikgruppe() {
    this.events = new ArrayList<Event>();
  }

  public void newEvent(Event e) {
    events.add(e);
  }

  public List<Event> getProben(Date begin, Date end) {
    return filter(events, begin, end, Probe.class);
  }

  public List<Event> getAuftritte(Date begin, Date end) {
    return filter(events, begin, end, Auftritt.class);
  }


  public List<Event> getEvents(Date begin, Date end) {
    return filter(events, begin, end, Event.class);
  }

  // can be used for mitglieder and repertoir too
  protected <T extends Timespan> List<T> filter(List<T> in, Date begin, Date end, Class cls) {
    final List<T> out = new ArrayList<T>();
    for(T e : in)
      if(e.getClass().isInstance(cls) && (e.getBegin().after(begin) || 
                                                     e.getEnd().before(end)))
        out.add(e);
    return out;
  }
}