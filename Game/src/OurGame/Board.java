
package OurGame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener, Runnable {
        Hero p; 
        Hero h;
        public Image img;
        Timer time;
        static int v = 700;
        Thread animator;
        private Music sound1;
        int killcount = 0;
        
        
Enemy en;
Enemy en2;
 
boolean lost = false;
 
        boolean a = false;
        boolean done2 = false;
       
        static Font font = new Font("SanSerif", Font.BOLD, 24);
        
	public void init(){
		Music.sound1.play();
	}
        public Board() {
                h = new Hero();
                addKeyListener(new AL());
                setFocusable(true);
                ImageIcon i = new ImageIcon("background.png");
                img = i.getImage();
                time = new Timer(5, this);
                time.start();
                en = new Enemy(700, 400, "hulk.png");
                en2 = new Enemy(2000, 400, "hulk.png");
                //init();
                new Thread(this).start();
        }
 
        public void actionPerformed(ActionEvent e) {
                checkCollisions();
                ArrayList bullets = Hero.getBullets();
                for (int w = 0; w < bullets.size(); w++)
                {
                        Bullet m = (Bullet) bullets.get(w);
                        if (m.getVisible() == true)
                        m.move();
                        else
                                bullets.remove(w);
                }
               
                h.move();
               
                if (h.x > 400)
                        en.move(h.getdx(), h.getLeft());
                if (h.x> 400)
                        en2.move(h.getdx(), h.getLeft());
                repaint();
        }
       
 
public void checkCollisions()
{
        Rectangle r1 = en.getBounds();
        Rectangle r2 = en2.getBounds();
        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++)
        {
                Bullet m = (Bullet) bullets.get(w);
                Rectangle m1 = m.getBounds();
                if (r1.intersects(m1) && en.Alive())
                {
                        en.isAlive = false;
                        m.visible = false;
                        killcount++;
                }
                else if (r2.intersects(m1)&& en2.Alive())
                {
                        en2.isAlive = false;
                        m.visible = false;
                        killcount++;
                }
        }
       
        Rectangle d = h.getBounds();
        if (d.intersects(r1))
        {
        	if(en.isAlive)
                lost = true;
        }
        if(d.intersects(r2))
        {
        	if(en2.isAlive)
        		lost=true;
        }
}
 
        public void paint(Graphics g) {
        	if (lost)
        	{
        		System.out.println("You lose.");
        		System.exit(0);
        	}
         
        if (h.dy == 1 && done2 == false) {
                        done2 = true;
                        animator = new Thread(this);
                        animator.start();
                }
 
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
 
                if ((h.getX() - 100) % 1500 == 0)// p.getX() == 100 || p.getX() == 2990)...
                        h.nx = 0;
                if ((h.getX() - 1790) % 1500 == 0)// p.getX() == 1790 || p.getX() == 4190)...
                        h.nx2 = 0;
 
                g2d.drawImage(img, 685 - h.getnX2(), 0, null);
                if (h.getX() > 100) {
                        g2d.drawImage(img, 685 - h.getnX(), 0, null);
                }
                g2d.drawImage(h.getImage(), h.left, v, null);
 
                if (h.getdx() == -1) {
                        g2d.drawImage(img, 685 - h.getnX2(), 0, null);
                        g2d.drawImage(h.getImage(), h.left, v, null);
                }
               
                ArrayList bullets = Hero.getBullets();
                for (int w = 0; w < bullets.size(); w++)
                {
                        Bullet m = (Bullet) bullets.get(w);
                        if (m.getVisible())
                        g2d.drawImage(m.getImage(),m.getX(), m.getY(), null);
                }
                g2d.setFont(font);
                g2d.setColor(Color.BLUE);
                g2d.drawString("Ammo left: " + h.ammo, 100, 20);
                g2d.drawString("Kill Count: "+killcount, 400, 20);
                if (h.x > 400)
                        if (en.Alive() == true)
                                g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
                if (h.x > 100)
                        if (en2.Alive() == true)
                                g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
        }
 
        private class AL extends KeyAdapter {
                public void keyReleased(KeyEvent e) {
                        h.keyReleased(e);
                }
 
                public void keyPressed(KeyEvent e) {
                        h.keyPressed(e);
                }
        }
 
        boolean done3 = false;
        boolean done = false;
 
        public void cycle() {
 
                if (done3 == false)
                        v--;
                if (v == 50)
                        done3 = true;
                if (done3 == true && v <= 475) {
                        v++;
                        if (v == 475) {
                                done = true;
                        }
                }
        }
 
        public void run() {
 
                long beforeTime, timeDiff, sleep;
 
                beforeTime = System.currentTimeMillis();
 
                while (done == false) {
 
                        cycle();
 
                        timeDiff = System.currentTimeMillis() - beforeTime;
                        sleep = 8 - timeDiff;
 
                        if (sleep < 0)
                                sleep = 2;
                        try {
                                Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
 
                        beforeTime = System.currentTimeMillis();
                }
                done = false;
                done3 = false;
                done2 = false;
        }
 
}