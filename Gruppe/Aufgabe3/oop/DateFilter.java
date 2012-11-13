package oop;

import java.util.Date;

/* filter payments according to date */
public class DateFilter implements PaymentFilter {
  private Date begin;
  private Date end;

  /* construct a new filter that will pass all payments that lie between 
    begin and end */
  public DateFilter(Date begin, Date end) {
    this.begin = begin;
    this.end = end;
  }

  /* returns true if the payment p passes this filter, ie if it's between 
    begin and end
   */
  public Boolean checkPayment(Payment p) {
    return p.getDate().after(begin) && p.getDate().before(end) ||
      p.getDate().equals(begin) || p.getDate().equals(end);
  }
}