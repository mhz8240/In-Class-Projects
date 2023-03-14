import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Part2 extends JPanel   {
	
	//"global variables"
	Random rnd = new Random(1234);
	int red = 0, green = 128, blue = 0;
	int angle = 0;
	int radius = 300;
	int offset = 180;
	int y = 0;
	public void paint(Graphics g) {
//		g.drawArc(10, 10, 1560, 1160, 90, 90);
//		g.drawArc(-770, 10, 1560, 1160, 0, 90);
		g.drawRect(10, 10, 780, 580);
		for (int i = 10; i < 790; i += 8) {
			g.drawLine(i, 10, 790, i);
		}
		for (int i = 10; i < 790; i += 8) {
			g.drawLine(800 - i, 10, 10, i);
		}
		for (int i = 10; i < 790; i += 8) {
			g.drawLine(800 - i, 590, 10, 590 - i);
		}
		for (int i = 10; i < 790; i += 8) {
			g.drawLine(i, 590, 790, 590 - i);
		}
		


		

	}// my code should go above this bracket unless I know about classes

	public static void main(String[] arg) {
		// line of code to create a MethodPractice object
		Part2 m = new Part2();

	}// end of main method body

	public Part2() {
		JFrame f = new JFrame("Loops and Random Numbers");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(820, 640);
		f.add(this);
		f.setVisible(true);
	}

}// last curly - do not delete