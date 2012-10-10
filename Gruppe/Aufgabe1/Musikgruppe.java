import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.xml.datatype.Duration;

public class Musikgruppe {
  protected List<Event> events;

  Musikgruppe() {
    this.events = new ArrayList<Event>();
  }

  public void neuesEreignis(Event e) {
    events.add(e);
  }

  public List<Event> getProben(Date beginn, Date ende) {
    return getEvents(beginn, ende, Probe.class);
  }

  public List<Event> getAuftritte(Date beginn, Date ende) {
    return getEvents(beginn, ende, Auftritt.class);
  }


  public List<Event> getEvents(Date beginn, Date ende) {
    return getEvents(beginn, ende, Event.class);
  }

  protected List<Event> getEvents(Date beginn, Date ende, Class cls) {
    final List<Event> out = new ArrayList<Event>();
    for(Event e : this.events)
      if(e.getClass().isInstance(cls) && (e.getBeginn().after(beginn) || 
                                          e.getEnde().before(ende)))
        out.add(e);
    return out;
  }
}