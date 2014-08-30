package test;

public class test {
	public static void main(String[] args){
		String str = "0123456789";
		str = str.substring(0,str.length()-1);
		System.out.println(str);
		String str1 = "Äã";
		byte[] bytes = str1.getBytes();
		System.out.println(bytes.length);
		
		Tank tank1 = new Tank();
		Tank tank2 = new Tank(3);
		Tank tank3 = new Tank(5);
		tank2.empty();
		//Drop the reference,forget to cleanup:
		new Tank(6);
		new Tank(7);
		System.out.println("Check tanks:");
		System.out.println("tank1:");
		tank1.sayHowFull();
		System.out.println("tank2:");
		tank2.sayHowFull();
		System.out.println("tank3");
		tank3.sayHowFull();
		System.out.println("first forced gc()");
		System.gc();
		System.out.println("try deprecated runFinalizerOnExit(true)");
		System.runFinalizersOnExit(true);
		System.out.println("last forced gc():");
		System.gc();
		
	}

}
