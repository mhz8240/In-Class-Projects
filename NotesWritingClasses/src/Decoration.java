
public class Decoration {
	private String color;
	private String object;
	private double weight;
	private boolean isScary;
	private String location;
	public Decoration() {
		color = "orange";
		object = "pumpkin";
		weight = 2.5;
		isScary = false;
		location = "in front of house";
	}
	public Decoration(String color, String object, double weight, boolean isScary, String location) {
		this.color = color;
		this.object = object;
		this.weight = weight;
		this.isScary = isScary;
		this.location = location;
	}
	public String toString() {
		String result = "";
		result += "color: " + color + "\n";
		result += "object: " + object + "\n";
		result += "weight: " + weight + "\n";
		result += "isScary: " + isScary + "\n";
		result += "location: " + location;
		return result;
	}
	
}
