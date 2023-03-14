
//https://github.com/domingodavid/froggerEclipse

package frog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener {

	int screen_width = 900;
	int screen_height = 935;
	Froggy froggy;
	Music hop = new Music("sweep.wav", false);
	// instantiate objct log
	// two obstacles
	Car[] car2 = new Car[7];
	Car[] car5 = new Car[9];
	
	// two rideable objects
	Car[] car3 = new Car[5];
	Car[] car4 = new Car[5];
	
	Background bg;
	int my_variable = 3; // example

	String lose = "";
	String win = "";
	String lost = "";
	boolean won = false;
	boolean ifLost = false;

	// ****************************paint
	// method******************************************
	public void paint(Graphics g) {

		super.paintComponent(g);
		bg.paint(g);
		Font f = new Font("Arial", 0, 150);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(("Lives:") + Integer.toString(my_variable), 0, 870);
		g.setFont(f);
		
		// paint sprites for carss
		for (int i = 0; i < car2.length; i++) {
			car2[i].paint(g);
		}
		for (int i = 0; i < car3.length; i++) {
			car3[i].paint(g);
		}
		for (int i = 0; i < car4.length; i++) {
			car4[i].paint(g);
		}
		for (int i = 0; i < car5.length; i++) {
			car5[i].paint(g);
		}
		// paint and update froggy
		froggy.paint(g);

		// car one
		g.drawString(lost, 0, 50);
		if (my_variable == 0) {
			ifLost = true;
			lose = " u lost";
			g.drawString(lose, 0, 50);
			my_variable = 3;
		}
		// if froggy collides with the first row of cars
		if (froggy.getY() > 210 && froggy.getY() < 275) {
			for (int i = 0; i < car2.length; i++) {
				if (Math.abs(car2[i].getX() - froggy.getX() + 17) < 37) {
					my_variable--;
					froggy.setX(425);
					froggy.setY(825);
				}
			}
		}
		// if froggy collides with second row of cars
		if (froggy.getY() > 85 && froggy.getY() < 150) {
			for (int i = 0; i < car5.length; i++) {
				if (Math.abs(car5[i].getX() - froggy.getX() + 17) < 34) {
					my_variable--;
					froggy.setX(425);
					froggy.setY(825);
				}
			}
		}
		// rideable logs
		boolean onLog = false;
		if (froggy.getY() > 470 && froggy.getY() < 550) {
			for (int i = 0; i < car3.length; i++) {
				if (Math.abs(car3[i].getX() - froggy.getX() + 20) < 44) {
					onLog = true;
					froggy.setVx(-3);
				}
			}
			if (!onLog || froggy.getX() < 5) {
				my_variable--;
				froggy.setX(425);
				froggy.setY(825);
			}
			
		}
		else if (froggy.getY() > 370 && froggy.getY() < 471) {
			for (int i = 0; i < car4.length; i++) {
				if (Math.abs(car4[i].getX() - froggy.getX() + 20) < 50) {
					onLog = true;
					froggy.setVx(5);
				}
			}
			if (!onLog || froggy.getX() < 5) {
				my_variable--;
				froggy.setX(425);
				froggy.setY(825);
			}
		}
		else {
			froggy.setVx(0);
		}
		// resetting
		if (my_variable > 0 && froggy.getY() < 50) {
			won = true;
			lose = "";
			win = "u won!";
			g.drawString(win, 0, 700);
			froggy.setX(425);
			froggy.setY(825);
		}
		// display won text
		if (won && froggy.getY() > 620) {
			g.drawString(win, 300, 250);
		}
		
	
		if (won && froggy.getY() < 620) {
			won = false;
		}
		// display lost text
		if (ifLost && froggy.getY() > 620) {
			g.drawString(lose, 300, 250);
		}
		if (ifLost && froggy.getY() < 620) {
			ifLost = false;
		}
	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	//
	public void update() {

		froggy.move();

		// car two
		for (int i = 0; i < car2.length; i++) {

			car2[i].setVx(-8);
			car2[i].move();

		}
		for (int i = 0; i < car3.length; i++) {

			car3[i].setVx(-6);
			car3[i].move();

		}
		for (int i = 0; i < car4.length; i++) {

			car4[i].setVx(10);
			car4[i].move2();

		}
		for (int i = 0; i < car5.length; i++) {

			car5[i].setVx(-5);
			car5[i].move();

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* *
	 * Used to setup all of the objects on the screen
	 */
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Frogger");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this); //listen for keypresses on this frame

		// sprite instantiation
		froggy = new Froggy("virus.png");

		for (int i = 0; i < car2.length; i++) {
			car2[i] = new Car("car.png", i * 135 + 400, 225);
		}
		
		for (int i = 0; i < car3.length; i++) {
			car3[i] = new Car("cd.png", i * 180 + 400, 475);
		}
		for (int i = 0; i < car3.length; i++) {
			car4[i] = new Car("cd.png", i * 180, 390);
		}
		for (int i = 0; i < car5.length; i++) {
			car5[i] = new Car("car.png", i * 105 + 400, 100);
		}
		// leave room here to instantiate other rows of obstacles
		// aka other cars, bulldozers, trucks, turtules, logs etc
		
		
		
		
		// Add background
		bg = new Background("newbackground.png");
		
		
		// do not add to frame, call paint on
		// these objects in paint method

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		// detect up, down, left, right arrow keypresses
		// call setters for volovety attributes accordingly
		// 37 <- ,
		// 38 up ,
		// 40 down,
		// 39 ->
//		hop.play();
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:		//up
			froggy.hop(0);
			break;
		
		case KeyEvent.VK_S:	
			froggy.hop(1);		//down
			break;
		case KeyEvent.VK_A:		//up
			froggy.hop(2);
			break;
		
		case KeyEvent.VK_D:	
			froggy.hop(3);		//down
			break;
		
		// handle going left and right
		// A and D keys
			
			
		}
		
		
		
		

	}

//	@Override
//	public void keyReleased(KeyEvent e) {
//		/*
//		 * turn off velocity for Frog if you don't want it moving when you have stopped
//		 * pressing the keys
//		 */
//		if (e.getKeyCode() == 38) {
//			froggy.setVy(0);
//			froggy.setVx(0);
//		}
//
//		if (e.getKeyCode() == 40) {
//			froggy.setVy(0);
//			froggy.setVx(0);
//		}
//
//		// do the same thing for the other keys
//	}
	public void keyReleased(KeyEvent arg0) {
        System.out.println(arg0.getKeyCode());
        froggy.setVx(0);
        froggy.setVy(0);
      
    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}