package CollectionTest;

public class Employee {
	
	private String name ; 
	
	private double salary;
	
	public Employee(String Name){
		name = Name;
		salary = 0;
	}
	
	public Employee(String Name , double Salary){
		name = Name ;
		salary = Salary;
	}
	
	public String toString()
	{
		return "[name="+name+",salary="+salary+"]";
	}
}
