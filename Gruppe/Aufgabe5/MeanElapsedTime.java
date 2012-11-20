import java.util.Iterator;

public class MeanElapsedTime extends ElapsedTime {
	private final Set<Double> times;

	public MeanElapsedTime() {
		this.times = new Set<Double>();
	}

	public Double getCompareTime() {
		if(this.count() == 0) return 0.0;
		Double sum = new Double(0);
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			sum+=d;
		return sum/this.count();
	}

	public void add(Double time) {
		times.insert(time);
	}

	public int count(){
		int c=0;
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			c++;
		return c;
	}

	public Double getLongest() {
		Double max = new Double(0);
		Iterator<Double> iter = times.iterator();
		for(Double d : times)
			if(d > max) max = d;
		return max;
	}

	@Override public String toString() {
		return String.format("%d timings, avg %7.1f - max %4.1f",
		 count(), getCompareTime(), getLongest());
	}
}