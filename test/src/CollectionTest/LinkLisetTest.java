package CollectionTest;

import java.util.*;

public class LinkLisetTest {
	
	public static void main(String[] args)
	{
		List<String> a = new LinkedList<String>();
		a.add("wangyue");
		a.add("shiqinchao");
		a.add("luming");
		a.add("chengqiang");
		
		List<String> b  = new LinkedList<String>();
		b.add("汪月");
		b.add("史庆超");
		b.add("路明");
		b.add("陈强");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext())
		{
			if(aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		bIter = b.iterator();
		while(bIter.hasNext())
		{
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println(b);
		
		a.addAll(2, b);
		
		System.out.println(a);
		
		a.removeAll(a);
		
		System.out.println(a);
		
		System.out.println("Lee".hashCode() + " " + "shiqingchao".hashCode());
	}

}
