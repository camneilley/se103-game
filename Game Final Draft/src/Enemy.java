import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Enemy {
	Image img;
	int x, y;
	boolean isAlive = true;
	
	public Enemy(int startX, int startY, String location)
	{
		x = startX;
		y = startY;
		ImageIcon l = new ImageIcon(location);
		img = l.getImage();
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 225, 225);
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;	
	}
	
	public boolean Alive()
	{
		return isAlive;
	}
	public void setAlive(boolean a)
	{
		isAlive = a;
	}
	
	public Image getImage()
	{
		return img;
	}
	
	public void move(int dx, int left)
	{
		if (dx ==1 && !((left + dx ) < 150))
		x = x - dx;
		
	}
}
