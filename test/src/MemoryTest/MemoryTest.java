package MemoryTest;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class MemoryTest {
	
	public static void main(String[] args){
	
	MemoryUsage mu = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage(); 
	 
	long getCommitted = mu.getCommitted(); 
	 
	long getInit = mu.getInit(); 
	 
	long getUsed = mu.getUsed(); 
	 
	long max = mu.getMax(); 
	 
	System.out.println(">>getCommitted(byte)>>"+getCommitted); 
	 
	System.out.println(">>getInit(byte)>>"+getInit); 
	 
	System.out.println(">>getUsed(byte)>>"+getUsed); 
	 
	System.out.println(">>max(byte)>>"+max); 
	
	}

}
