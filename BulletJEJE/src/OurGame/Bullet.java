package OurGame;
//click on "Move "whatever class" to package "OurGame"
 
import java.awt.*;
import javax.swing.*;
 
public class Bullet {
        int x, y;//-- Controls the CURRENT location of THIS bullet
        //Each object of this class is a new BULLET
         Image img;
        boolean visible;
        //sets weather THIS bullet is visible or not
 
       
        public int getX()
        {
                return x;
        }
 
        public boolean getVisible()
        {
                return visible;
        }
       
        public int getY()
        {
                return y;
        }
       
        public Image getImage()
        {
                return img;
        }
       
        public Bullet(int startX, int startY)
        {
                ImageIcon newBullet = new ImageIcon("bullet.jpg");
                img = newBullet.getImage();
                x = startX;
                y = startY;
                visible = true;
        }
        //Just like the move class in Dude class...
        public void move(){
                x = x + 2; //x + bullet speed
                if (x > 700)// if x > board width
                        //Make the bullet invisible
                        visible = false;
        }
}