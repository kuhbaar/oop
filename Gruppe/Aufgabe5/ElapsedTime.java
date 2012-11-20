public abstract class ElapsedTime implements Shorter<ElapsedTime>{
	public boolean shorter(ElapsedTime t){
		return this.getCompareTime() < t.getCompareTime();
	}

	public abstract Double getCompareTime();

	public abstract int count();
}