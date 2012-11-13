public class DarkBox extends Box{
	public DarkBox (int width, int height, char border){
		super(width, height, border, border);
	}

	public void changeChar(char c){
		this = new DarkBox(this.width,this.height,c);
	}
}