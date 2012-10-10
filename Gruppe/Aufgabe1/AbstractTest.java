// this is a runtime exception so users of the test framework don't have to
// declare the exception for each and every test, which would be very tedious
class AssertException extends RuntimeException {
  AssertException(String msg) {
    super(msg);
  }
}

// this is the base class for all tests which provides useful utility functions
public class AbstractTest {
  void assertEqual(Object a, Object b) {
    if(a == null && b == null) return;
    if(a == null || !a.equals(b)) throw new AssertException(String.format("%s wasn't equal to %s", a, b));
  }
}