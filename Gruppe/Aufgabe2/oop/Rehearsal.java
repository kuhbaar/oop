package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Rehearsal extends Event {
  public Rehearsal(String ort, Date begin, Date end,  BigDecimal rent) { 
    super(ort, begin, end, rent.negate());
  }
  public BigDecimal getRent() { return balance.negate(); }
}