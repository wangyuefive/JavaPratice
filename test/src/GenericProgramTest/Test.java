package GenericProgramTest;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args)
	{
		Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
	}

}
