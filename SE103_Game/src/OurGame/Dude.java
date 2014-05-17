package OurGame;
 
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
import javax.swing.ImageIcon;
 
public class Dude {
        int x, dx, y,nx,nx2,left, dy;
        Image still,jump,reverse;
       
        int ammo = 9999;
 
         static ArrayList<Bullet> bullets; //Holds number of bullets on screen
       
        ImageIcon s = new ImageIcon("still.png");
        ImageIcon j= new ImageIcon("still.png");
        ImageIcon l = new ImageIcon("still.png");
       
        public static ArrayList<Bullet> getBullets()
        {
                return bullets;
        }
        public Dude() { // location where the player starts at
                x = 75;
                left = 150;
                nx = 0;
                nx2= 685;
                y = 172;
                still = s.getImage();
                bullets = new ArrayList<Bullet>();//j
       
        }
       
        public void fire()//Method to run when when fired
        {
               
                System.out.println(bullets.size() + " " + ammo);
                if (ammo > 0){
                        ammo--;
                //Create a new bullet object and add it to
                //array "list" of all bullets on screen.
                Bullet z = new Bullet((left + 180), (y + 154/2));
                bullets.add(z);}
        }
        public void move() { //background and player moving
                if (dx != -1){
                        if (left + dx <= 150)
                                left+=dx;
                        else{
                        	x = x + dx;
                        	nx2= nx2+dx;
                        	nx = nx + dx;
                        }
                }
                else{
                	
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
        // when arrows button are being press
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT){
                	dx = -1;
                	still = l.getImage();           
                }
                if (key == KeyEvent.VK_RIGHT){ // how fast player will travel to the right
                	dx = 1;
                	still = s.getImage();  
                }
                if (key == KeyEvent.VK_SPACE){ // calls method fire()
                    fire();
                }
                if (key == KeyEvent.VK_UP){ // player jumps
                	dy = 1;
                    still = j.getImage();
                }
        }
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                if (key == KeyEvent.VK_LEFT){ 
                        dx = 0;
                }
                if (key == KeyEvent.VK_RIGHT){
                        dx = 0;
                }
                if (key == KeyEvent.VK_UP){
                	dy = 0;
                    still = s.getImage();}
        		}
        }