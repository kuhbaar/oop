public class CompositeTime extends ElapsedTime{
	private Double[] times;

	public CompositeTime(Double[] d){
		this.times = d;
	}

	public Double getCompareTime(){
		Double sum = new Double(0);
		for(int i=0; i<times.length; i++){
			sum+=times[i];
		}
		return sum;
	}

	public int count(){
		return times.length;
	}

	public Double getShortest(){
		Double min = new Double(Double.MAX_VALUE);
		for(int i=0; i<times.length; i++){
			if(times[i] < min)
				min = times[i];
		}
		return min;
	}
}