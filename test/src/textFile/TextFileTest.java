package textFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {

	public static void main(String[] args) throws IOException{
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("汪月", 1000, 2013, 4, 30);
		staff[1] = new Employee("史庆超", 1000, 2013, 4, 29);
		staff[2] = new Employee("路明", 1000, 2013, 4, 28);
		
		try
		{
			PrintWriter out = new PrintWriter("employee.dat","UTF-8");
			writeDate(staff, out);
		}
		catch(IOException e)
		{
			
		}
		
		
		try
		{
			Scanner in = new Scanner(new FileInputStream("employee.dat"),"UTF-8");
			Employee[] newStaff   = readDate(in);
			for(Employee e : newStaff)
			{
				System.out.print(e);
			}
		}
		catch(IOException e)
		{
			
		}
	}

	protected static Employee[] readDate(Scanner in) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		in.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i =0 ; i < n; i++)
		{
			employees[i] = readEmploee(in);
		}
		return employees;
	}


	private static Employee readEmploee(Scanner in) {
		// TODO Auto-generated method stub
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		int year = Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[3]);
		int day = Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);

	}

	private static void writeDate(Employee[] staff, PrintWriter out) {
		// TODO Auto-generated method stub
		out.println(staff.length);
		for(Employee e: staff)
			writeEmployee(out,e);
	}

	private static void writeEmployee(PrintWriter out, Employee e) {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.println(e.getName()+"|"+e.getSalary()+"|"+calendar.get(Calendar.YEAR) + "|"
				+(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}

}
