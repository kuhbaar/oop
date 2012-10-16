import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;
import test.*;

public class MemberTest extends AbstractTest{
	Date a,b,c,d;

	@BeforeClass
	public void InitializeCommonValues(){
		Calendar cal = Calendar.getInstance();
    	cal.set(2012, 9, 15);
    	a = cal.getTime();

    	cal.set(2012, 10, 4);
    	b = cal.getTime();

	    cal.set(2012, 10, 10);
   		c = cal.getTime();
  
    	cal.set(2012, 10, 5);
    	d = cal.getTime();
	}
	@UnitTest
	public void testMembersAccessors() {
    	Member m = new Member("klaus","Moor", new BigDecimal("0815"), "Chello");
    	assertEqual(m.getName(), "klaus Moor");
    	assertEqual(m.getPhoneNo(), new BigDecimal("0815"));
    	assertEqual(m.getInstrument(), "Chello");
        assertEqual (m.getBegin(), new Date(Long.MAX_VALUE));
    	assertEqual(m.getEnd(), new Date(Long.MAX_VALUE));
  }
}