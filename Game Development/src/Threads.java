
import java.util.Random;

public class Threads implements Runnable {

	String name;
	int time;
	Random r=new Random();
	
	public Threads(String s){
		name = s;
		time = r.nextInt(1000);
	}
	
	public void run(){
		try{
		System.out.println(name+" is sleeping for "+time);
		Thread.sleep(time);
		System.out.println(name+" "+time);
		}
		catch(Exception e){}
	}
	
}
