
package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Substitute extends Member{
	
	public Substitute(String name, String surname, String phoneno, String inst){
		super(name,surname,phoneno,inst);
	}

	public Substitute(Member m){
		super(m);
	}

	public boolean isAvailable(){

		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		Date a = new Date(System.currentTimeMillis() - (7 * DAY_IN_MS));

	
		for(Date e:proben){
			if (e.before(a)) return false;

		}
		return true;
	}
	

}