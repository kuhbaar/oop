import java.util.Date;
import java.math.BigDecimal;

public class Probe extends Event {
  public Probe(String ort, BigDecimal raummiete) { 
    super(ort, raummiete);
  }
  public BigDecimal getRaummiete() { return kosten; }
}