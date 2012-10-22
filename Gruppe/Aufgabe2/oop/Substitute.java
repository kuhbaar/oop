
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
}