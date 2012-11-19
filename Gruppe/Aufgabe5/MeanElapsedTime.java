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

	public Double getLongest(){
		Double max = new Double(0);
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			if(d > max) max = d;
		return max;
	}
}