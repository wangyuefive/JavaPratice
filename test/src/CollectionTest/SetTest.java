package CollectionTest;

import java.util.*;

public class SetTest {
	
	public static void main(String[] args)
	{
		HashSet<String> words = new HashSet<String>();
		long totaltime = 0 ;
		
		Scanner in = new Scanner(System.in);
		System.out.print(" ‰»Î“ª◊È”¢”Ô£∫");
		while(in.hasNext())
		{
			String word =in.next();
			if(word.equals("exit"))
				break;
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totaltime += callTime;
		}
		
		Iterator<String> iter = words.iterator();
		for(int i =0 ; i < words.size() && iter.hasNext(); i++)
			System.out.println(iter.next());
		System.out.println("========================");
		System.out.println(words.size() + " distinct words  " + totaltime + "∫¡√Î");
	}

}
