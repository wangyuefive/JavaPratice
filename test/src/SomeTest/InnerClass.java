package SomeTest;

public class InnerClass {
	
	private Integer a = new Integer(10);
	
	private Integer geta(){
		return this.a;
	}
	public InnerClass(){
		System.out.print(" class is " + a);
	}
	
	public class inner{
		public inner(){
			System.out.println(" " + InnerClass.this.geta());
		}
	}

}
