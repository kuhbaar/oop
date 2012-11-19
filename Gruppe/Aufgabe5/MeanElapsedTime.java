import java.util.Iterator;

public class MeanElapsedTime extends ElapsedTime{
	private Set<Double> times;

	public MeanElapsedTime(){
		this.times= new Set<Double>();
	}

	public Double getCompareTime(){
		Double sum = new Double(0);
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			sum+=d;
		return sum/this.count();
	}
	public boolean shorter(ElapsedTime t){
		return this.getCompareTime() < t.getCompareTime();
	}

	public void add(Double time){
		times.insert(time);
	}

	public int count(){
		int c=0;
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			c++;
		return c;
	}
}