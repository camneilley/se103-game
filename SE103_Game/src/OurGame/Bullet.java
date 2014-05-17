package OurGame;
//click on "Move "whatever class" to package "OurGame"
 
import java.awt.*;
import javax.swing.*;
 
public class Bullet {
        int x, y;//-- Controls the CURRENT location of THIS bullet
        //Each object of this class is a new BULLET
         Image img;
        boolean visible; //sets weather the bullet is visible or not
        
        //gets current location of the bullet
        public int getX(){
        	return x;
        }
        public boolean getVisible(){
        	return visible;
        }
        public int getY(){
        	return y;
        }
        public Image getImage(){
        	return img;
        }
        // starting point of bullet
        public Bullet(int startX, int startY){
                ImageIcon newBullet = new ImageIcon("bullet.jpg");
                img = newBullet.getImage();
                x = startX;
                y = startY;
                visible = true;
        }
        //bullet speed and how far it will travel
        public void move(){
                x = x + 2; //x + bullet speed
                if (x > 2000)// how far bullet will travel
                        //Make the bullet invisible
                        visible = false;
        }
}