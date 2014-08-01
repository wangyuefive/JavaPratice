package ExceptionTest;

import java.io.IOException;


public class ExceptionTest {
	
	public static void main(String[] args) 
	{
		try
		{
			System.out.print("\n==========try0============\n");
			int c = test(0);
			System.out.print("\n==========try1============\n");
		}
		catch(IOException e)
		{
			System.out.print("\n=========catch============\n");
			StackTraceElement[] t = e.getStackTrace();
			for(StackTraceElement f: t)
				System.out.print(f.toString()+ "\n");
		}
		finally
		{
			System.out.print("\n==========finally============\n");
		}
	}
	
	private static int test(int i) throws IOException
	{
		if(i == 0)
			throw new IOException();
		else
			System.out.print("\n========in test=========\n");
		return i;
	}
}

