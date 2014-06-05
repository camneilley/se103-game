

import java.awt.*;

import javax.swing.ImageIcon;


public class Laser {
	
	int x, y; //location of laser
	Image img;
	boolean visible;
	
	public Laser(int startX, int startY){
		
		x = startX;
		y = startY;
		ImageIcon newLaser = new ImageIcon("bullet.jpg");
		img = newLaser.getImage();
		visible = true;
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 31, 3);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;	
	}
	
	public boolean getVisible()
	{
		return visible;
	}
	
	public Image getImage()
	{
		return img;
	}
	public void setVisible(boolean a)
	{
		visible = a;
	}
	
	public void move()
	{
		x = x + 5;
		if ( x > 1540)
			visible = false;
	}
	

}
