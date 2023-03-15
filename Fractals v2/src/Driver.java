import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;
	private int runs = 0;

	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D gd = (Graphics2D) g;
		rings(gd, 350, 375, 375);
//		triangles(g, 400, 25, 750, 0);
		
//		squares(g, 400, 400, 250, 0);
		runs++;
		

	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {
//		g.draw
	

	}
	public void squares(Graphics g, int x, int y, int size, int iteration) {
		if (iteration == 4) {
			return;
		}
		Color c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		g.setColor(c);
		g.fillRect(x-size/2, y-size/2, size,size);
		squares(g, x-size, y-size, size/3, iteration + 1);
		squares(g, x-size, y, size/3, iteration + 1);
		squares(g, x-size, y+size, size/3, iteration + 1);
		squares(g, x, y-size, size/3, iteration + 1);
		squares(g, x, y+size, size/3, iteration + 1);
		squares(g, x+size, y-size, size/3, iteration + 1);
		squares(g, x+size, y, size/3, iteration + 1);
		squares(g, x+size, y+size, size/3, iteration + 1);
		
		
	}
	public void rings(Graphics2D g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		g.rotate(Math.toRadians(90), x, y);
		
		
		if (radius > 1) {
			rings(g, radius-3, x, y);
		}
	}
	
	public void triangle(Graphics g, int[] x, int[] y) {
		g.drawPolygon(x, y, 3);
	}
	public void triangles(Graphics g, int x, int y, int size, int iteration) {
		if (iteration == 0) {
			int[] xPoints = {x, x - size/2, x + size/2};
			int[] yPoints = {y, y + (int)(Math.sqrt(3) * size/2), y + (int)(Math.sqrt(3) * size/2) };
			triangle(g, xPoints, yPoints);
			triangles(g, x, y + (int)(Math.sqrt(3) * size/2), size/2, iteration + 1);
		}
		else if (iteration == 1) {
			int[] xPoints = {x, x - size/2, x + size/2};
			int[] yPoints = {y, y - (int)(Math.sqrt(3) * size/2), y - (int)(Math.sqrt(3) * size/2) };
			triangle(g, xPoints, yPoints);
			triangles(g, x, y - (int)(Math.sqrt(3) * size/2), size/2, iteration + 1);
			triangles(g, x+size/2, y, size/2, iteration + 1);
			triangles(g, x-size/2, y, size/2, iteration + 1);
		}
		else if (iteration > 3) {
			return;
		}
		else  {
			int[] xPoints = {x, x - size/2, x + size/2};
			int[] yPoints = {y, y - (int)(Math.sqrt(3) * size/2), y - (int)(Math.sqrt(3) * size/2) };
			triangle(g, xPoints, yPoints);
			triangles(g, x, y - (int)(Math.sqrt(3) * size/2), size/2, iteration + 1);
			triangles(g, x+size/2, y, size/2, iteration + 1);
			triangles(g, x-size/2, y, size/2, iteration + 1);
		}
	}	
	/**
	 * Update the positions of the ball and paddle. Update the scores, counter
	 * and time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
//		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}
