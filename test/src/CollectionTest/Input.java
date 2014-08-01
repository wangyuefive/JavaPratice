package CollectionTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<String> name = new ArrayList<String>();
		int i = 0;
		while(in.hasNext()){
			name.add(in.next());
			System.out.println(name);
		}
		System.out.println("=========\n");
	}

}
