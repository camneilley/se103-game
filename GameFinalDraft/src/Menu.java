
import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
	
	JButton newGame = new JButton("New Game");
	JButton quit = new JButton("Quit Game");
	JButton JustADream=new JButton("Just a Dream");
	
	static boolean check = false;	
	Box box1;
	Box box2;
	

	public Menu(){
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setSize(600,600);
		setTitle("Superman Target Practice Menu");
		setVisible(true);


		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame f = new Frame();	
				f.main(null);
			}
		});
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(ABORT);
			}
		});
		JustADream.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MakeSound a=new MakeSound();
				a.playSound("JustADream.wav");
			}
		});
		add(newGame,BorderLayout.WEST);
		add(quit,BorderLayout.EAST);
		add(JustADream,BorderLayout.CENTER);
		
		


	}
	
	

	public static void main(String[] args) {

		Menu m = new Menu();

	}

}