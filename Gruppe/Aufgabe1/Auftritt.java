import java.util.Date;
import java.math.BigDecimal;

public class Auftritt extends Event {
  public Auftritt(String ort, Date beginn, Date ende, BigDecimal gage) { 
    super(ort, beginn, ende, gage.negate());
  }
  public BigDecimal getGage() { return kosten.negate(); }
}