package myunit;

import java.util.List;
import java.util.ArrayList;

public class SampleTest extends AbstractTest {
  List<String> l;

  @BeforeClass
  public void MySetupMethod() {
    l = new ArrayList<String>();
    l.add("hallo");
    l.add("world");
  }

  @UnitTest
  public void IsOneEqualToTwo() {
    assertEqual(1, 1);            
  }                             

  @UnitTest
  public void myOtherTest() {
    assertEqual(3, 3);
    assertNotEqual(null, 2);
  }

  @UnitTest
  public void CheckStringAddition() {
    String str = new String("ha");
    String str2 = new String("llo");
    assertEqual(str + str2, "hallo");
  }

  @UnitTest
  public void StringAdditionIsNotSameObject() {
    String str = new String("ha");
    String str2 = new String("llo");
    assertIsNot(str + str2, "hallo");       
  }

  @UnitTest
  public void ElementShouldBeInList() {
    assertIn("hallo", l);
  }

  @UnitTest
  public void aFailingTestAgain () {
    assertTrue(true);
  }

  @UnitTest
  public void StringShouldntBeAnInteger () {
    assertIsNotInstance("hello", Integer.class);
  }

  @UnitTest
  @AssertThrows(exception = RuntimeException.class)
  public void TestThatThrows() {
    int i = 0;
    throw new RuntimeException("da test");
  }
  

  public void otherMethod() {
    System.out.println("I won't run");
  }
}