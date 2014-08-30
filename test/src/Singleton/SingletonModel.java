package Singleton;

public class SingletonModel {
	
	private static SingletonModel instance =null;  //��̬��
	
	private static Object object = new Object();
	
	private SingletonModel(){
		System.out.println("----->>>>>Singleton construct begin ");
		int i = 0 ;
		int j = 0 ;
		while(i++ < 200)  //������ʱ֮��
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
				/**���⣬���︳ֵ �� ʵ�����ֳ����������̣���Ϊnew�Ĺ��̾�
				 * �ǹ�������ʼ���Ĺ��̣�����Ҫʱ�䡣����仰��ʾ��JVM����
				 * ��һ��SingletonModel���ڴ�ռ䣬Ȼ��instance���������
				 * �ڴ�ռ䣬Ȼ�󼴷����ˣ���ʱ������ʵ����û�г�ʼ����ɡ�
				 * �����ʱ��һ�����̽�������ôinstance���ǻ���ʾnull
		        */
			}
		}
		System.out.println("current thread:"+Thread.currentThread().getId()+
		" out ");
		return instance;	
	}

}
