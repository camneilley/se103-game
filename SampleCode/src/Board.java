//click on "Move "whatever class" to package "OurGame"
package OurGame;
 
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener, Runnable {
        Dude p;
        public Image img;
        Timer time;
        int v = 172;
        Thread animator;
 
         static Font font = new Font("SanSerif", Font.BOLD, 24);
         
        boolean a = false;
        boolean done2 = false;
       
        public Board() {
                p = new Dude();
                addKeyListener(new AL());
                setFocusable(true);
                ImageIcon i = new ImageIcon("testp.jpg");
                img = i.getImage();
                time = new Timer(5, this);
                time.start();
        }
 
        public void actionPerformed(ActionEvent e) {
       
                ArrayList bullets = Dude.getBullets();
                for (int w = 0; w < bullets.size(); w++)
                {
                        //This is how to get a current element in an arrayList
                        //similar to x[2] in a normal array
                         Bullet m = (Bullet) bullets.get(w);//draw:
                         if (m.getVisible() == true)
                         {
                                 m.move();
                         }
                         else bullets.remove(w);
                }
 
 
               
                p.move();
                repaint();
        }
 
        public void paint(Graphics g) {
                if (p.dy == 1 && done2 == false) {
                        done2 = true;
                        animator = new Thread(this);
                        animator.start();
                }
p.y = v;
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
 
                //Get bullets from ArrayList
               
                if ((p.getX() - 590) % 2400 == 0)// p.getX() == 590 || p.getX() == 2990)
                        p.nx = 0;
                if ((p.getX() - 1790) % 2400 == 0)// p.getX() == 1790 || p.getX() == 4190)
                        p.nx2 = 0;
 
                g2d.drawImage(img, 685 - p.getnX2(), 0, null);
                if (p.getX() > 590) {
                        g2d.drawImage(img, 685 - p.getnX(), 0, null);
                }
               
                g2d.drawImage(p.getImage(), p.left, v, null);
 
                if (p.getdx() == -1) {
                       
                        g2d.drawImage(img, 685 - p.getnX2(), 0, null);
                        g2d.drawImage(p.getImage(), p.left, v, null);
                }
               
                ArrayList bullets = Dude.getBullets();
                for (int w = 0; w < bullets.size(); w++)
                {
                        //This is how to get a current element in an arrayList
                        //similar to x[2] in a normal array
                         Bullet m = (Bullet) bullets.get(w);//draw:
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);
 
                }
                g2d.setFont(font);
                g2d.setColor(Color.BLUE);
                g2d.drawString("Ammo left: " + p.ammo, 500, 50);
        }
 
        private class AL extends KeyAdapter {
                public void keyReleased(KeyEvent e) {
                        p.keyReleased(e);
                }
 
                public void keyPressed(KeyEvent e) {
                        p.keyPressed(e);
                }
        }
 
        boolean h = false;
        boolean done = false;
 
        public void cycle() {
 
                if (h == false)
                        v--;
                if (v == 125)
                        h = true;
                if (h == true && v <= 172) {
                        v++;
                        if (v == 172) {
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
                        sleep = 10 - timeDiff;
 
                        if (sleep < 0)
                                sleep = 2;
                        try {
                                Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                                System.out.println("interrupted");
                        }
 
                        beforeTime = System.currentTimeMillis();
                }
                done = false;
                h = false;
                done2 = false;
        }
 
}