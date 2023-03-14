import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	private int x, y;
	private int vx, vy;
	private Color color;
	public Cell() {
		x = (int)(Math.random() * 800);
		y = (int)(Math.random() * 600);
		vx = 0;
		vy = 0;
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		color = new Color(red, green, blue);
	}
	public Cell(int initX, int initY) {
		this();
		x = initX;
		y = initY;
		
	}
	public void paint(Graphics daniel) {
		 x += vx;
		 y += vy;
		daniel.setColor(color);
		daniel.fillOval(x, y, 20, 20);

	}
	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	public int getX () {
		return x;
	
	}
	public int getY () {
		return y;
	
	}
	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}
}
