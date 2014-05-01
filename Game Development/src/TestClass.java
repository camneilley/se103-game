
public class TestClass {
	public static void main(String[] args){
		
		Thread t=new Thread(new Threads("tee"));
		Thread t2=new Thread(new Threads("two"));
		Thread t3=new Thread(new Threads("three"));
		
		t.start();
		t2.start();
		t3.start();
	}
}
