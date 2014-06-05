import javax.swing.*;


public class Frame {

	public static void main(String[] args){
		
		JFrame frame = new JFrame("Superman Target Practice");
	frame.add(new Screen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1540,768);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
