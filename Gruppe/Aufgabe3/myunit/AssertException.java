package myunit;

public class AssertException extends RuntimeException {
  static final long serialVersionUID = 1;
  AssertException(String msg) {
    super(msg);
  }
}