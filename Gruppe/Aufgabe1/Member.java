import java.math.BigDecimal;
import java.util.Date;

public class Member implements Timespan{
	public Member(String name, String surname, String phoneno, String inst){
		this.Name=name;
		this.Surname=surname;
		this.PhoneNo=phoneno;
		this.Instrument=inst;
		this.Join=new Date(Long.MAX_VALUE);
		this.Leave=new Date(Long.MAX_VALUE);
	}
	public Member(Member m){
		this.Name=m.getName();
		this.Surname=m.getSurname();
		this.PhoneNo=m.getPhoneNo();
		this.Instrument=m.getInstrument();
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
		Member m = new Member(Name, Surname, PhoneNo, Instrument);
		m.Join = this.Join;
		m.Leave= new Date();
		return m;
	}
	public Member join(){
		Member m = new Member(Name,Surname,PhoneNo,Instrument);
		m.Leave=this.Leave;
		m.Join=new Date();
		return m;
	}
	public String toString(){
		return (Name + " " + Surname + " " + PhoneNo + " " + Instrument);
	}

	protected String Name;
	protected String Surname;
	protected String PhoneNo;
	protected String Instrument;
	protected Date Join;
	protected Date Leave;
}