package NetTest;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class InetAddrTest {
	public static void main(String[] args) throws IOException{
		
			Scanner in = new Scanner(System.in);
			String host = in.nextLine();
			System.out.print(host);
			InetAddress[] addr = InetAddress.getAllByName(host);
			for(InetAddress a : addr)
				System.out.print(a.toString()+"\n");
		
		
		
			InetAddress localAddr = InetAddress.getLocalHost();
			System.out.print(localAddr);
		
	}

}
