package myunit;

// this is a runtime exception so users of the test framework don't have to
// declare the exception for each and every test, which would be very tedious
public class AssertException extends RuntimeException {
  static final long serialVersionUID = 1;
  AssertException(String msg) {
    super(msg);
  }
}