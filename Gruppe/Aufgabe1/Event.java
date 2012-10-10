import java.util.Date;
import java.math.BigDecimal;

public class Event implements Timespan {
  public Event(String ort, Date begin, Date end, BigDecimal kosten) { 
    this.ort = ort;
    this.begin = begin;
    this.end = end;
    this.kosten = kosten;
  }

  public String getOrt() { return ort; }       
  public BigDecimal getKosten() { return kosten; }

  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }

  protected String ort;
  protected Date begin;
  protected Date end;
  protected BigDecimal kosten;
}
