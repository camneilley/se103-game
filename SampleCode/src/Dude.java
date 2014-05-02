//click on "Move "whatever class" to package "OurGame"
package OurGame;
 
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
import javax.swing.ImageIcon;
 
public class Dude {
        int x, dx, y,nx,nx2,left, dy;
        Image still,jump,reverse;
       
        int ammo = 10;
 
         static ArrayList bullets;//Holds number of bullets on screen
       
        ImageIcon s = new ImageIcon("still.png");
        ImageIcon j= new ImageIcon("still.png");
        ImageIcon l = new ImageIcon("still.png");
       
        public static ArrayList getBullets()
        {
                return bullets;
        }
        public Dude() {
                x = 75;
                left = 150;
                nx = 0;
                nx2= 685;
                y = 172;
                still = s.getImage();
                bullets = new ArrayList();//j
       
        }
       
        public void fire()//Method to run when when fired
        {
               
                System.out.println(bullets.size() + " " + ammo);
                if (ammo > 0){
                        ammo--;
                //Create a new bullet object and add it to
                //array "list" of all bullets on screen.
                Bullet z = new Bullet((left + 60), (y + 154/2));
                bullets.add(z);}
        }
 
        public void move() {
                if (dx != -1){
                        if (left + dx <= 150)
                                left+=dx;
                        else{
                x = x + dx;
               
                nx2= nx2+dx;
                        nx = nx + dx;
        }}
                else
        {
                if (left+dx >0)
                left = left + dx;
        }
                }
 
        public int getX() {
                return x;
        }
 
        public int getnX() {
                return nx;
        }
       
        public int getnX2() {
                return nx2;
        }
 
        public int getdx() {
                return dx;
        }
       
        public Image getImage() {
                return still;
        }
 
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT)
                {               dx = -1;
                still = l.getImage();           }
               
                if (key == KeyEvent.VK_RIGHT)
                        {dx = 1;
                still = s.getImage();  
                        }
               
                if (key == KeyEvent.VK_SPACE)
                {
                        fire();
                }
               
                if (key == KeyEvent.VK_UP)
                        {dy = 1;
                        still = j.getImage();
                        }                       }
 
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                if (key == KeyEvent.VK_LEFT)
                        dx = 0;
 
                if (key == KeyEvent.VK_RIGHT)
                        dx = 0;
               
                if (key == KeyEvent.VK_UP)
                        {dy = 0;
                        still = s.getImage();}
                        }
        }