package oop;

import java.util.List;
import java.util.ArrayList;

public class UnionFilter implements PaymentFilter {
  private PaymentFilter[] filters;
  
  public UnionFilter(PaymentFilter... filters) {
    this.filters = filters;
  }

  public Boolean checkPayment(Payment p) {
    for(PaymentFilter f : filters)
      if(!f.checkPayment(p))
        return false;
    return true;
  }
}