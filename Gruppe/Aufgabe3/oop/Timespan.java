package oop;

import java.util.Date;

public interface Timespan {
  /* simple interface to get begin and end of some thing. This allows easy
   * filtering of objects by date ranges 
   */
  public Date getBegin();
  public Date getEnd();
}