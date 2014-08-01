package ThreadTest;

public class TimerRunnable implements Runnable {
	
	private  int i = 0;
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("time is " + i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

