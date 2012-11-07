package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Payment {
  /* construct a new payment with description, amount, date;  date must not be null */
  public Payment(String description, BigDecimal amount, Date date) {
    this.description = description;
    this.amount = amount;
    this.date = new Date(date.getTime());
  }

  /* construct a new payment with description, amount and the current time */
  public Payment(String description, String amount) {
    this(description, new BigDecimal(amount), new Date());
  }

  /* deep copy of payment */
  public Payment(Payment p) {
    this(p.description, p.amount, p.date);
  }

  /* accessors, return immutable copy */
  public BigDecimal getAmount() { return amount; }
  public Date getDate() { return new Date(date.getTime()); }

  protected final String description;
  protected final BigDecimal amount;
  protected final Date date;
}