package oop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Member implements Timespan{
	protected String Name;
	protected String Surname;
	protected String PhoneNo;
	protected String Instrument;
	protected Date Join;
	protected Date Leave;
	protected List<Event> Message;

	public Member(String name, String surname, String phoneno, String inst){
		this.Name=name;
		this.Surname=surname;
		this.PhoneNo=phoneno;
		this.Instrument=inst;
		this.Join=new Date(Long.MAX_VALUE);
		this.Leave=new Date(Long.MAX_VALUE);
	}

	public Member(Member m){
		this(m.Name, m.Surname, m.PhoneNo, m.Instrument);
		this.Join=m.getBegin();
		this.Leave=m.getEnd();
	}

	public String getName(){return Name;}
	public String getSurname(){return Surname;}
	public String getPhoneNo(){return PhoneNo;}
	public String getInstrument(){return Instrument;}
	public Date getBegin(){return Join;}
	public Date getEnd(){return Leave;}

	public Member leave(){
		Member m = new Member(this);
		m.Leave= new Date();
		return m;
	}

	public Member join(){
		Member m = new Member(this);
		m.Join=new Date();
		return m;
	}
	public String toString(){
		return (Name + " " + Surname + " " + PhoneNo + " " + Instrument);
	}
}