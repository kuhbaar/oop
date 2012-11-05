package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Payment {
  public Payment(String description, BigDecimal amount, Date date) {
    this.description = description;
    this.amount = amount;
    this.date = new Date(date.getTime());
  }

  public Payment(String description, String amount) {
    this(description, new BigDecimal(amount), new Date());
  }

  public Payment(Payment p) {
    this(p.description, p.amount, p.date);
  }

  public BigDecimal getAmount() { return amount; }
  public Date getDate() { return new Date(date.getTime()); }

  protected final String description;
  protected final BigDecimal amount;
  protected final Date date;
}