package oop;

public interface PaymentFilter {
  /* GOOD: concrete filters override / implement this method, which makes it
     trivial to implement new filters without changing any other code.
   */
  public Boolean checkPayment(Payment p);
}