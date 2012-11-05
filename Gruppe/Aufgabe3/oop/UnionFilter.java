package oop;

import java.util.List;
import java.util.ArrayList;

public class UnionFilter implements PaymentFilter {
  private PaymentFilter[] filters;
  
  /* construct a new filter that will pass all payments that pass all the filters
  in the list "filters" */
  public UnionFilter(PaymentFilter... filters) {
    this.filters = filters;
  }


  /* returns true if the payment p passes this filter, ie if it passes all
    the filters in the list
   */
  public Boolean checkPayment(Payment p) {
    for(PaymentFilter f : filters)
      if(!f.checkPayment(p))
        return false;
    return true;
  }
}