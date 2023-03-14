import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

	// parts of a class - instance vars /properties
	// attributes
	private int x, y; //location
	private int width, height; //size
	private Color c;
	private int vy;
	
	//constructor that allow setting of the location 
	public Paddle(int newX, int newY) {
		//assigns values to the attributes
		x = newX;
		y = newY;
		width = 20;
		height = 125;
		c = Color.black;
	}
	
	public void paint(Graphics g) {
		
		//update y
		y += vy; //velocity in y affects position in the y
		
		//set the color
		g.setColor(c);
		g.fillRect(x, y, width, height);
	
	}
	
	//SETTER - allows outsiders to set some value 
	//in the class
	public void setVelocity(int newVy) {
		vy = newVy;
	}
	public int getY() {
		return y;
	}
	public void setRed() {
		c = Color.red;
	}
	public void setGreen() {
		c = Color.green;
	}
}
