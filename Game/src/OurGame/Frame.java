package OurGame;
 
import javax.swing.*;
 
public class Frame {
 
        public Frame(){
                JFrame frame = new JFrame();
                frame.add(new Board());
                frame.setTitle("Super Side Scroller!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1900,750);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
        }
        public static void main(String[] args){
                new Frame();
        }
}