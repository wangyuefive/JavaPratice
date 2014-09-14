package Singleton;

public class SingletonMain {

	public static void  main(String[] args){
		/**
		SingletonModel model1 = SingletonModel.getInstance();	
		SingletonModel model2= SingletonModel.getInstance();
		if(model1 == model2)
			System.out.println("model1 == model2");
			 */
		Thread th1 = new Thread(new sigRunnable());
		Thread th2 = new Thread(new sigRunnable());
		th1.start();
		th2.start();
		System.out.println("------>>>>>>>>>");
		SingletonModel model = SingletonModel.getInstance();
		System.out.println("------<<<<<<<<<");
	}
	
}
