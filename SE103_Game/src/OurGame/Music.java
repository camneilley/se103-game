package OurGame;
import java.applet.Applet;
import java.applet.AudioClip;

public class Music {
		
	public static final Music sound1 = new Music("/poop.wav"); // get song file from /res
		
	private AudioClip clip; // creates clip object
		
	public Music(String filename){
		try{
			clip = Applet.newAudioClip(Music.class.getResource(filename));
		}
		catch (Exception e){ //prints out error is there's any
			e.printStackTrace(); 
		}
	}
	public void play(){ //method to play song
		try{
			new Thread(){
				public void run(){
					clip.play();
					clip.loop();
				}
			}.start();
		}
		catch(Exception ex){ //prints out error is there's any
			ex.printStackTrace();
		}
	}
} 
	

