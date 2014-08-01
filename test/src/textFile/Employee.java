package textFile;

import java.util.Date;
import java.util.GregorianCalendar;


public class Employee {

	public Employee(String n ,double s, int year ,int month, int day)
	{
		name = n;
		salary = s ;
		GregorianCalendar calendar = new GregorianCalendar(year,month -1, day);
		hireDate = calendar.getTime();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public Date getHireDay()
	{
		return this.hireDate;
	}
	
	public void raiseSalary(double percent)
	{
		double raise = this.salary *(1+percent/100);
		this.salary += raise;
	}
	
	private String name;
	
	private double salary;
	
	private Date hireDate;
}
