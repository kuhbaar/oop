import java.util.Date;
import java.math.BigDecimal;

public class Auftritt extends Event {
  public Auftritt(String ort, BigDecimal gage) { 
    super(ort, gage.negate());
  }
  public BigDecimal getGage() { return kosten.negate(); }
}