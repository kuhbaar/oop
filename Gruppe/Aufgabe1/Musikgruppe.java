import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.Duration;

public class Musikgruppe {
  protected List<Record<Event>> events;

  Musikgruppe() {
    this.events = new ArrayList<Record<Event>>();
  }

  public void newEvent(Event e, Date begin, Date end) {
    events.add(new Record<Event>(e, begin, end));
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
  protected <T> List<T> filter(List<Record<T>> in, Date begin, Date end, Class cls) {
    final List<T> out = new ArrayList<T>();
    for(Record<T> e : in)
      if(e.getValue().getClass().isInstance(cls) && (e.getBegin().after(begin) || 
                                                     e.getEnd().before(end)))
        out.add(e.getValue());
    return out;
  }
}