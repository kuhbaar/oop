// all test classes should extend AbstractTest to get useful utility methods
public class SampleTest extends AbstractTest {
  // all tests need to be annotated with @UnitTest and have a void () signature
  @UnitTest
  public void testMyFirstMethod() {
    assertEqual(1, 2);            // one such utility method is assertEqual, which
  }                               // prints its arguments if the assertion fails

  @UnitTest
  public void myOtherTest() {
    assertEqual(3, 3);
  }


  @UnitTest
  public void andAthirdOne() {
    String str = new String("ha");
    String str2 = new String("llo");
    assertEqual(str + str2, "hallo");
  }


  // if a method isn't annotated, it will never run
  public void otherMethod() {
    System.out.println("I won't run");
  }
}