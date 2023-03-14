import java.awt.Color;
import java.awt.Graphics;

public class Pumpkin {
	private int x;
	private int y;
	
	public Pumpkin() {
		
	}
	public void paint(Graphics g) {
		g.setColor(new Color(255,60,0));
		g.fillOval(200, 200, 200, 160);
		g.setColor(new Color(196,164,132));
		g.fillRect(280, 160, 40, 60);
		g.setColor(new Color(0,0,0));
		g.fillPolygon(new int[] {260, 242, 278}, new int[] {250, 275, 275}, 3);
		g.fillPolygon(new int[] {340, 322, 358}, new int[] {250, 275, 275}, 3);
		g.fillOval(250, 300, 100, 35);
	}
}
