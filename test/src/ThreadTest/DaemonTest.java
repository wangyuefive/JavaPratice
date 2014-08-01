package ThreadTest;

public class DaemonTest {
	
	public static void main(String[] args){
		System.out.println("enter main:");
		Thread timer = new Thread(new TimerRunnable());
		//timer.setDaemon(true);
		timer.start();
		System.out.println("exit main:");	
	}

}
