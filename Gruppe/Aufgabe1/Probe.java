import java.util.Date;
import java.math.BigDecimal;

public class Probe extends Event {
  public Probe(String ort, Date beginn, Date ende, BigDecimal raummiete) { 
    super(ort, beginn, ende, raummiete);
  }
  public BigDecimal getRaummiete() { return kosten; }
}