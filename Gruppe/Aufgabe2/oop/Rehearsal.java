package oop;

import java.util.Date;
import java.math.BigDecimal;
import java.util.Stack;

public class Rehearsal extends Event {
  public Rehearsal(String location, Date begin, Date end,  BigDecimal rent) { 
    super(location, begin, end, rent.negate());
  }
  public Rehearsal(Rehearsal r){
  	super(r);
  }
  public BigDecimal getRent() { return balance; }
}