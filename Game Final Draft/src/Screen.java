import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.math.*;

import javax.swing.*;




public class Screen extends JPanel implements ActionListener, Runnable {
	Hero h;
	Image background;
	Timer time;
	Thread animator;
	static int v = 500;
	Random random;
	Enemy en;
	Enemy[] enemies = new Enemy[40];
	static int deathCount=0;
	static int killCount=0;
	
	boolean k = false;
	boolean lost = false;
	
	static Font font = new Font("SanSerif", Font.ITALIC, 20);
	
	public Screen(){
		h = new Hero();
		addKeyListener(new AL());
		setFocusable(true); //Allows screen to move left and right
		ImageIcon i = new ImageIcon("background.png");
		background = i.getImage();
		time = new Timer(5, this);
		time.start();           
		random = new Random();
		for(int j = 0; j<40  ; j++)
		{
			enemies[j]= new Enemy(random.nextInt(10000)+300, random.nextInt(500)+50, "hulk.png");
		}
		
		
		
	}
	
	public void actionPerformed (ActionEvent e) {
		checkCollisions();
	
		ArrayList lasers = Hero.getLasers();
		for (int i = 0; i < lasers.size(); i++)
		{
			Laser m = (Laser)lasers.get(i);
			if (m.getVisible()) 
			m.move();
			else
				lasers.remove(i);
		}
		
		
		
		h.move();
		
		
		for(int a=0; a<enemies.length; a++)
		{
			if(h.x>300)
			{
				enemies[a].move(h.getDX(), h.getLeft());
			}
		}
		
		repaint();
		
	}
	public void checkCollisions()
	{
		
		ArrayList lasers = Hero.getLasers();
		
			for (int i = 0; i < lasers.size(); i++)
			{
				for(int j=0; j<enemies.length; j++)
				{
					Rectangle h1 = h.getBounds();
					Rectangle r1 = enemies[j].getBounds();
					Laser m = (Laser)lasers.get(i);
					Rectangle m1 = m.getBounds();
			
					if(r1.intersects(m1) && enemies[j].isAlive)
					{					
						enemies[j].isAlive=false;
						killCount++;
						//enemies[j].x
						m.setVisible(false);
						repaint();
					}
					if(h1.intersects(r1) && enemies[j].isAlive)
					{
						//System.out.println(r1.x+","+r1.y+","+r1.width+","+r1.height);
						//System.out.println(h.x); 
						//System.out.println(h.y);
						lost = true;
					}			
				
				}
			}
		
	}

	
	public void paint (Graphics g){
		if(lost)
		{
			deathCount++;
			System.out.println(deathCount);
			lost=false;
		}
		if ((h.dy == 1) && (k ==false))
		{
			k = true;
			animator = new Thread(this);
			animator.start();
		}
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
	if ((h.getX() - 590) % 4080 == 0)
		h.nx = 0;
	if ((h.getX() - 2630) % 4080 == 0)
		h.nx2 = 0;
		
		g2d.drawImage(background, 1525-h.nx2, 0, null);
		
		if (h.getX() >= 590)
			g2d.drawImage(background, 1525-h.nx, 0, null);
		g2d.drawImage(h.getImage(), h.left, v, null);
		  if (h.getDX() == -1) {
              g2d.drawImage(background, 1525 - h.getNX2(), 0, null);
              g2d.drawImage(h.getImage(), h.left, v, null);
		  }
		
		ArrayList lasers = Hero.getLasers();
		for (int i = 0; i < lasers.size(); i++)
		{
			Laser m = (Laser) lasers.get(i);
			if(m.getVisible())
			g2d.drawImage(m.getImage(),m.getX(), m.getY(), null);
		}
		
		g2d.setFont(font);
		g2d.setColor(Color.MAGENTA);
		g2d.drawString("Ammo Remaining: " + h.ammo, 450, 20);
	
		for(int i = 0; i<enemies.length; i++)
		{	
				if (enemies[i].Alive() == true)
					if(enemies[i].getX()-h.getX()<700)
					g2d.drawImage(enemies[i].getImage(), enemies[i].getX(), enemies[i].getY(), null);
				
		}
		
		
	}
	
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			h.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e){
			h.keyPressed(e);
		}
		
		}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		while(done == false) 
		{
			cycle();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 2 - timeDiff;
			if (sleep < 0)
				sleep = 2;
			try{
				Thread.sleep(sleep);
			}
			catch (Exception e)
			{}
			beforeTime = System.currentTimeMillis();
		}
		done = false;
		p = false;
		k = false;
	}
	boolean done = false; // when jump is complete, done is true
	boolean p = false;
	
	public void cycle(){ //changes y value of character
		if (p == false)
			v--;
		if (v == 200)
			p = true;
		if (p == true && v<= 500){
			v++;
			if (v == 500)
				done = true;
		}
	}
	
	}


