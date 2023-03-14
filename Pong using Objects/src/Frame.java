import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener{
	static Ball ball = new Ball(375,275,25);
	static Paddle paddle1 = new Paddle(100, 200);
	static Paddle paddle2 = new Paddle(680, 200);
	
	int i = 0;
	int j = 0;
	/* paint is getting called roughly 60x per second */
	public void paint(Graphics g) {
		super.paintComponent(g);
		ball.paint(g);
		paddle1.paint(g);
		paddle2.paint(g);
		paddle1.setRed();
		paddle2.setGreen();
		String s = "" + i;
		String str = "" + j;
		g.setColor(Color.black);
		g.drawString(s, 50, 50);
		g.drawString(str, 725,50);
		if (ball.getX() >= 750) {
			i++;
			ball.setVelocityX(-5);
			ball.setX(375);
			ball.setY(275);
			ball.setVx(-5);
			ball.setVy(5);
		}
		if (ball.getY() >= 550) {
			
			ball.setVy(-25);
		}
		if (ball.getX() <= 0) {
			j++;
			ball.setVelocityX(5);
			ball.setX(375);
			ball.setY(275);
			ball.setVx(5);
			ball.setVy(5);
		}
		if (ball.getY() <= 0) {
			ball.setVy(25);
		}
		if (ball.getX() >= 105 && ball.getX() < 130 && ball.getY() > (paddle1.getY() - 25) && ball.getY() < (paddle1.getY() + 125)) {
			ball.setVx(25);
			
		}
		if (ball.getX() > 650 && ball.getX() <= 675 && ball.getY() > (paddle2.getY() - 25) && ball.getY() < (paddle2.getY() + 125)) {
			ball.setVx(-25);
		
		}
	
		
	}
	
	
	public static void main(String[] arg) {
		ball.setVx(-5);
		ball.setVy(5);
		Frame f = new Frame();
		
	}	
	
	@Override
	public void keyPressed(KeyEvent key) {
//		System.out.println(key.getKeyCode());
		if (key.getKeyCode() == 87) {
			if (!(paddle1.getY() < 0)) {
				paddle1.setVelocity(-15);
			}
			else {
				paddle1.setVelocity(0);
			}
		}
		if (key.getKeyCode() == 83) {
			if (!(paddle1.getY() > 450)) {
				paddle1.setVelocity(15);
			}
			else {
				paddle1.setVelocity(0);
			}
		}
		if (key.getKeyCode() == 38) {
			if (!(paddle2.getY() < 0)) {
				paddle2.setVelocity(-15);
			}
			else {
				paddle2.setVelocity(0);
			}
		}
		if (key.getKeyCode() == 40) {
			if (!(paddle2.getY() > 450)) {
				paddle2.setVelocity(15);
			}
			else {
				paddle2.setVelocity(0);
			}
		}
//		switch(key.getKeyCode()) {
//		case 87:
//		paddle1.setVelocity(-20);
//		break;
//		case 83: 
//		paddle1.setVelocity(20);
//		break;
//		case 38:
//		paddle2.setVelocity(-20);
//		break;
//		case 40:
//		paddle2.setVelocity(20);
//		break;
		}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		paddle1.setVelocity(0);
		paddle2.setVelocity(0);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	Timer t;
	
	public Frame() {
		JFrame f = new JFrame("Pong");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.addKeyListener(this);
		
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
	}
}
