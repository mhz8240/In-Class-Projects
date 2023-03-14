import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Part1 extends JPanel {
	
	//"global variables"
	Random rnd = new Random(1234);

	public void paint(Graphics g) {

		// Draw Grid
		g.drawRect(10, 10, 780, 580);
		g.drawLine(400, 10, 400, 590);
		g.drawLine(10, 300, 790, 300);
		int counter = 0;
		while (counter < 100) {
			int x1 = (int)(Math.random() * 275) + 25;
			int y1 = (int)(Math.random() * 275) + 25;
			int x2 = rnd.nextInt(275) + 25;
			int y2 = rnd.nextInt(275) + 25;
			int red = rnd.nextInt(256);
			int green = rnd.nextInt(256);
			int blue = rnd.nextInt(256);
			g.setColor(new Color(red, green, blue));
			g.drawLine(x1, y1, x2, y2);
			counter++;
		}
		counter = 0;
		while (counter < 100) {
			int x = rnd.nextInt(250) + 400;
			int y = rnd.nextInt(200) + 50;
			int red = rnd.nextInt(256);
			int green = rnd.nextInt(256);
			int blue = rnd.nextInt(256);
			g.setColor(new Color(red, green, blue));
			g.drawRect(x, y, 50, 50);
			counter++;
		}
		counter = 0;
		while (counter < 100) {
			int diameter = rnd.nextInt(200);
			int x = rnd.nextInt(350 - diameter) + 25;
			int y = rnd.nextInt(250 - diameter) + 325;
			int red = rnd.nextInt(256);
			int green = rnd.nextInt(256);
			int blue = rnd.nextInt(256);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, diameter, diameter);
			counter++;
		}
			

		
		
		
		
		
		
		
		

	}// my code should go above this bracket unless I know about classes

	public static void main(String[] arg) {
		// line of code to create a MethodPractice object
		Part1 m = new Part1();

	}// end of main method body

	public Part1() {
		JFrame f = new JFrame("Loops and Random Numbers");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(820, 640);
		f.add(this);
		f.setVisible(true);

	}

}// last curly - do not delete