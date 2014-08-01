package Settest;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedlistTest {
	
	public static void main(String[] args )
	{
		List<String> a = new LinkedList<String>();
		a.add("123");
		a.add("345");
		a.add("678");
		
		List<String> b = new LinkedList<String>();
		b.add("123");
		b.add("345");
		b.add("678");
		
		ListIterator<String> iter = a.listIterator();
	}

}
