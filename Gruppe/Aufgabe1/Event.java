import java.util.Date;
import java.math.BigDecimal;

public class Event {
  public Event(String ort, Date beginn, Date ende, BigDecimal kosten) { 
    this.ort = ort;
    this.beginn = beginn;
    this.ende = ende;
    this.kosten = kosten;
  }

  public String getOrt() { return ort; }            
  public Date getBeginn() { return beginn; }
  public Date getEnde() { return ende; }
  public long getDuration() { 
    return ende.getTime() - beginn.getTime();
  }
  public BigDecimal getKosten() { return kosten; }

  protected String ort;
  protected Date beginn;
  protected Date ende;
  protected BigDecimal kosten;
}

/* compare to a proper language (Scala in this case):

public case class Event(ort: String, beginn: Date, ende: Date) {
  def getDuration: long = ende.getTime() - beginn.getTime()
}

*/