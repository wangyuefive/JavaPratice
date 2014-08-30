package Singleton;

public class sigRunnable implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SingletonModel model = SingletonModel.getInstance();
	}

}
