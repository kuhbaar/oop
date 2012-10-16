import java.math.BigDecimal;
import java.util.Date;

public class Member implements Timespan{
	public Member(String name, String surname, BigDecimal phoneno, String inst){
		this.Name=name;
		this.Surname=surname;
		this.PhoneNo=phoneno;
		this.Instrument=inst;
		this.Join=new Date();
		this.Leave=new Date(Long.MAX_VALUE);
	}
	public String getName(){return Name+" "+Surname;}
	public BigDecimal getPhoneNo(){return PhoneNo;}
	public String getInstrument(){return Instrument;}
	public Date getBegin(){return Join;}
	public Date getEnd(){return Leave;}
	public Member leave(){
		Member m = new Member(Name, Surname, PhoneNo, Instrument);
		m.Join = this.Join;
		m.Leave=new Date();
		return m;
	}

	protected String Name;
	protected String Surname;
	protected BigDecimal PhoneNo;
	protected String Instrument;
	protected Date Join;
	protected Date Leave;
}