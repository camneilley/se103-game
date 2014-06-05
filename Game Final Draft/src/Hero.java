import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Hero {
	int x, y, dx, dy, nx2, nx, left;
	int ammo = 20;
	Image still;
	ImageIcon i = new ImageIcon("still.png");
	
	static ArrayList lasers;
	
	
	
	
public Hero(){

	still = i.getImage();
	
	
	x = 75;
	nx = 0;
	nx2 = 1525;
	y = 500;
	left = 150;
	lasers = new ArrayList();
	
	
	
}
public Rectangle getBounds()
{
	return new Rectangle(x, y, 225, 225);
}

public static ArrayList getLasers()
{
	return lasers;
	
}

public void fire()
{
	if (ammo>0)
	{
		Laser z = new Laser((left + 175), (Screen.v + 77));
		lasers.add(z);
		ammo --;
		
	}
	else
	{
		System.out.println("Game over.");
		JOptionPane.showInputDialog("You Killed: "+Screen.killCount+" enemies.");
		JOptionPane.showInputDialog("You died: "+Screen.deathCount+" times.  This is an example of a collision issue. :(");
		JOptionPane.showInputDialog("You hit "+((Screen.killCount*1.0)/20)*100+"percent of shots");
		System.exit(0);
	}
}

public void move(){
	if (dx != -1){ //only if moving to right
		if (left + dx <= 150) // moves actual character if further left than 150
			left = left + dx;
		else{
	x = x + dx;
	nx2 = nx2 + dx;
	nx = nx + dx;
		}
	}
	
	else
	{
		if (left + dx > 0)
			left = left + dx;
	}
	
}

public int getX(){
	return x;
}

public int getDX(){
	return dx;
}

public int getY(){
	return y;
}

public int getLeft(){
	return left;
}

public Image getImage(){
	return still;
}
public int getNX2()
{
	return nx2;
}

public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_LEFT){
	dx = -1;	
	}	
	if (key == KeyEvent.VK_RIGHT){	
	dx = 1;
	}
	if (key == KeyEvent.VK_SPACE){	
		fire();
		}
	if (key == KeyEvent.VK_UP)
	{
		dy = 1;
		
	}
}
public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_LEFT)
	dx = 0;
	if (key == KeyEvent.VK_RIGHT)
	dx = 0;
	if (key == KeyEvent.VK_UP)
	dy = 0;
	
	
}

}
