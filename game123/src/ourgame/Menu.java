package OurGame;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
		
		JPanel jp = new JPanel();
		JButton newGame = new JButton("New Game");
		JButton quit = new JButton("Quit Game");
		static boolean check = false;		


	public Menu(){
		
		setSize(400,155);
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
		jp.add(newGame);
		jp.add(quit);
		add(jp);
		
	
	}

	public static void main(String[] args) {
		
		Menu m = new Menu();

	}

}
