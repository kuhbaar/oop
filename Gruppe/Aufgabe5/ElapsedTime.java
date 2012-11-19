public interface ElapsedTime extends Shorter<ElapsedTime>{
	public boolean shorter(ElapsedTime t);

	public int count();
}