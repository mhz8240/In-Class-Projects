
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decoration decoration = new Decoration();
		System.out.println(decoration);

	}

}

class Ghost {
	public String name;
	private double opacity;
	private double height;
	private boolean isScary;
	public Ghost() {
		name = "Boo";
		opacity = 0.0;
		height = 5.0;
		isScary = false;
	}
}