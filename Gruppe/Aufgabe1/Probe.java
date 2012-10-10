import java.util.Date;
import java.math.BigDecimal;

public class Probe extends Event {
  public Probe(String ort, Date begin, Date end,  BigDecimal raummiete) { 
    super(ort, begin, end, raummiete);
  }
  public BigDecimal getRaummiete() { return kosten; }
}