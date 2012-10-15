import java.util.Date;
import java.math.BigDecimal;

public class Auftritt extends Event {
  public Auftritt(String ort, Date begin, Date end,  BigDecimal gage) { 
    super(ort, begin, end, gage);
  }
  public BigDecimal getGage() { return balance; }
}