import java.awt.*;
import javax.swing.JFrame;
public class Screen {
	
	private GraphicsDevice gD;
	
	public Screen(){
		GraphicsEnvironment gE=GraphicsEnvironment.getLocalGraphicsEnvironment();
		gD=gE.getDefaultScreenDevice();
		
	}
	
	public void fullScreen(DisplayMode dm, JFrame window){
		window.setUndecorated(true);
		window.setResizable(false);
		gD.setFullScreenWindow(window);
	}

}
