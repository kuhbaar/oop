import java.util.Date;
import java.math.BigDecimal;

public class Event {
  public Event(String ort, BigDecimal kosten) { 
    this.ort = ort;
    this.kosten = kosten;
  }

  public String getOrt() { return ort; }       
  public BigDecimal getKosten() { return kosten; }

  protected String ort;
  protected BigDecimal kosten;
}
