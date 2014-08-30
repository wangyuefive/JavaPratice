package Singleton;

public class SingletonModel {
	
	private static SingletonModel instance =null;  //静态类
	
	private static Object object = new Object();
	
	private SingletonModel(){
		System.out.println("----->>>>>Singleton construct begin ");
		int i = 0 ;
		int j = 0 ;
		while(i++ < 200)  //以做延时之用
			while(j++ < 2000000000);
		System.out.println("<<<<<<-----Singleton construct out");
	}
	
	public static SingletonModel getInstance(){
		if(instance == null){
			System.out.println("current thread:"+Thread.currentThread().getId()+
			" current instance is null");
			synchronized (object) {
				if(instance == null){
					System.out.println("current thread:"+Thread.currentThread().getId()+
					" current instance is null");
					instance = new SingletonModel(); 
				} 
				/**问题，这里赋值 和 实例化分成了两个过程，因为new的过程就
				 * 是构造器初始化的过程，这需要时间。而这句话显示，JVM分配
				 * 了一个SingletonModel的内存空间，然后instance引用了这个
				 * 内存空间，然后即返回了，此时，可能实例还没有初始化完成。
				 * 如果此时另一个进程进来，那么instance还是会显示null
		        */
			}
		}
		System.out.println("current thread:"+Thread.currentThread().getId()+
		" out ");
		return instance;	
	}

}
