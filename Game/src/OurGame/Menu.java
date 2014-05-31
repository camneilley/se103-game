package OurGame;

import javax.swing.*;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
	JLabel message = new JLabel("Welcome to Super Side Scroller!");
	JPanel jp = new JPanel();
	JButton newGame = new JButton("New Game");
	JButton quit = new JButton("Quit Game");
	String[] characters = {"Superman", "Batman", "Mario"};
	JComboBox charselect = new JComboBox(characters);
	static boolean check = false;	
	Box box1;
	Box box2;
	

	public Menu(){
		box1 = Box.createHorizontalBox();
		box2 = Box.createVerticalBox();
		setSize(600,600);
		setTitle("Game");
		setVisible(true);


		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame f = new Frame();	
			}
		});

		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(ABORT);
			}
		});
		box2.add(newGame);
		box2.add(quit);
		box2.add(charselect);
		box1.add(message);
		box1.add(box2);
		add(box1);


	}

	public static void main(String[] args) {

		Menu m = new Menu();

	}

}