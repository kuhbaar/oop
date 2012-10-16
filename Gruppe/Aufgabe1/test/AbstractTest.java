package test;

import java.util.List;
import java.math.BigDecimal;

// this is the base class for all tests which provides useful utility functions
public class AbstractTest {
  public void assertEqual(Object a, Object b) {
    if(a == null && b == null) return;
    if(a == null || !a.equals(b)) throw new AssertException(String.format("%s wasn't equal to %s", a, b));
  }

  public void assertEqual(BigDecimal a, BigDecimal b) {
    if(a == null && b == null) return;
    if(a == null || a.compareTo(b) != 0) throw new AssertException(String.format("%s wasn't equal to %s", a, b));
  }

  public void assertNotEqual(Object a, Object b) {
    if(a == null && b != null) return;
    if(a == null || a.equals(b)) throw new AssertException(String.format("%s was equal to %s", a, b));
  }

  public void assertIs(Object a, Object b) {
    if(a != b) throw new AssertException(String.format("%s isn't %s (==)", a, b));
  }

  public void assertIsNot(Object a, Object b) {
    if(a == b) throw new AssertException(String.format("%s isn't %s (==)", a, b));
  }

  public <T> void assertIn(T a, List<T> b) {
    if(! b.contains(a)) throw new AssertException(String.format("%s is not in %s", a, b));
  }

  public <T> void assertNotIn(T a, List<T> b) {
    if(b.contains(a)) throw new AssertException(String.format("%s is in %s", a, b));
  }

  public void assertTrue(boolean cond) {
    if(!cond) throw new AssertException("assertion failed");
  }

  public void assertIsInstance(Object a, Class cls) {
    if(!cls.isInstance(a)) throw new AssertException(
      String.format("%s is not an instance of %s", a, cls.getName()));
  }

  public void assertIsNotInstance(Object a, Class cls) {
    if(cls.isInstance(a)) throw new AssertException(
      String.format("%s is an instance of %s", a, cls.getName()));
  }
}