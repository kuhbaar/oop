package oop;

import java.util.Date;

public class DateFilter implements PaymentFilter {
  private Date begin;
  private Date end;

  public DateFilter(Date begin, Date end) {
    this.begin = begin;
    this.end = end;
  }

  public Boolean checkPayment(Payment p) {
    return p.getDate().after(begin) && p.getDate().before(end) ||
      p.getDate().equals(begin) || p.getDate().equals(end);
  }
}