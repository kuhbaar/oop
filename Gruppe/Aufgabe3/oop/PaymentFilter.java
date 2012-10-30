package oop;

public interface PaymentFilter {
  /* GOOD: concrete filters override / implement this method, which makes it
     trivial to implement new filters without changing any other code.
   */
  /* returns true if the payment p passes this filter (concrete functionality 
   * provided by implementing classes)
   */
  public Boolean checkPayment(Payment p);
}