import java.awt.Component;
import javax.swing.JFrame;
 
public class Runner extends JFrame {
 
    public Runner() {
        super();
        setSize(1220, 750);
 
        ScrollingBackground back = new ScrollingBackground();
        ((Component)back).setFocusable(true);
        getContentPane().add(back);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new Runner();
    }
 
}