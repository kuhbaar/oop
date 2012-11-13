public class DarkBox extends Box{
	public DarkBox (int width, int height, char border){
		super(width, height, border, border);
	}

	public DarkBox changeChar(char c){
		return new DarkBox(this.width,this.height,c);
	}
}