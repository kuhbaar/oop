package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Payment {
  public Payment(String description, BigDecimal amount, Date date) {
    this.description = description;
    this.amount = amount;
    this.date = new Date(date.getTime());
  }

  public Payment(String description, BigDecimal amount) {
    this(description, amount, new Date());
  }


  public Payment(String description, String amount) {
    this(description, new BigDecimal(amount));
  }

  public Payment(String description, String amount, Date date) {
    this(description, new BigDecimal(amount), date);
  }

  public BigDecimal getAmount() { return amount; }
  public Date getDate() { return new Date(date.getTime()); }

  protected String description;
  protected BigDecimal amount;
  protected Date date;
}