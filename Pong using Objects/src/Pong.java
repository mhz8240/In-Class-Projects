//currently everything works except for the point system for player 1
//will increment by 1 whenever paddle 1 is below half of the y-axis and by 3 when it is above it

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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pong extends JPanel implements KeyListener, ActionListener {
//	Ball ball = new Ball(200,300);
//	Paddle paddle1 = new Paddle(50,300);
//	Paddle paddle2 = new Paddle(700, 300);
//	Pumpkin p = new Pumpkin();
    Timer t;
    Cell cell = new Cell();
    Ball[] balls = new Ball[1000]; 
           
    /* paint is getting called roughly 60x per second */
    public void paint(Graphics g) {
        super.paintComponent(g);
        cell.paint(g);
//       for (Ball ball: balls) {
//    	   ball.paint(g);
    	if (cell.getX() >= 750) {
//   			i++;
   			cell.setVx(-5);
   		}
   		if (cell.getY() >= 550) {
   			
   			cell.setVy(-5);
   		}
   		if (cell.getX() <= 0) {
//   			j++;
   			cell.setVx(5);
   			
   		}
   		if (cell.getY() <= 0) {
   			cell.setVy(5);
   		}
//   		if (ball.getX() >= 105 && ball.getX() < 130 && ball.getY() > (paddle1.getY() - 25) && ball.getY() < (paddle1.getY() + 125)) {
//   			ball.setVx(25);
//   			
//   		}
//   		if (ball.getX() > 650 && ball.getX() <= 675 && ball.getY() > (paddle2.getY() - 25) && ball.getY() < (paddle2.getY() + 125)) {
//   			ball.setVx(-25);
//   		
//   		}
       }
//       paddle1.paint(g);
//       paddle2.paint(g);
       
////    	p.paint(g);
   
   
    public void keyPressed(KeyEvent key) {
        System.out.println(key.getKeyCode());
        if (key.getKeyCode() == 87) {
			if (!(cell.getY() < 0)) {
				cell.setVy(-15);
			}
			else {
				cell.setVy(0);
			}
		}
		if (key.getKeyCode() == 83) {
			if (!(cell.getY() > 450)) {
				cell.setVy(15);
			}
			else {
				cell.setVy(0);
			}
		}
		if (key.getKeyCode() == 65) {
			if (!(cell.getX() < 0)) {
				cell.setVx(-15);
			}
			else {
				cell.setVx(0);
			}
		}
		if (key.getKeyCode() == 68) {
			if (!(cell.getX() > 450)) {
				cell.setVx(15);
			}
			else {
				cell.setVx(0);
			}
		}
    }
//
//
    public void keyReleased(KeyEvent arg0) {
        System.out.println(arg0.getKeyCode());
        cell.setVx(0);
        cell.setVy(0);
      
    }


    public void keyTyped(KeyEvent arg0) {
       
       
    }
    
    
    
    //Frame Setup code below ---------------------------------
    public static void main(String[] arg) {
    	Pong p = new Pong();
    }
    
    public Pong() {
    	//Name of title bar of the GUI
    	for (int index = 0; index < balls.length; index++) {
    		balls[index] = new Ball();
    	}
    			JFrame f = new JFrame("Pong");
    			
    			//makes sure that the program stops when the window is close
    			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //don't delete
    			
    			//GUI dimensions - width - height
    			f.setSize(800,600);
    			
    			
    			f.add(this);
    			f.addKeyListener(this);
    			
    			t = new Timer(16, this);
    			t.start();
    			f.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
   
}