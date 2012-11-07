
package oop;

import java.util.Date;
import java.math.BigDecimal;

//subclass of Member
//the only difference is a slightly different toString Method as well as another isAvailableMethod

public class Substitute extends Member {
	
	public Substitute(String name, String surname, String phoneno, String inst) {
		super(name,surname,phoneno,inst);
	}

	public Substitute(Member m){
		super(m);
	}

	//returns true if there are no Dates older than d in the Date[] proben of the Substitute

	public boolean isAvailable(Date d){

		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		Date a = new Date(d.getTime() - (7 * DAY_IN_MS));

		for(Date e:proben){
			if (e==null || e.before(a)) return false;

		}
		return true;
	}

	//creates a new Substitute m copying this one and sets m.Join to the current Date
	//returns the created Substitute

	@Override public Member join(){
		Substitute m = new Substitute(this);
		m.Join=new Date();
		return m;
	}

	//creates a new Substitute m copying this one and sets m.Leave to the current Date
	//returns the created Substitute

	public Member leave(){
		Substitute m = new Substitute(this);
		m.Leave= new Date();
		return m;
	}
	

	public String toString(){
		return ("Substitute: " + name + " " + surname + " " + phoneno + " " + instrument);
	}

}