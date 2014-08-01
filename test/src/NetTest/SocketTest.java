package NetTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class SocketTest {
	
	public static void main(String[] args) throws IOException{
		try{
			//Socket packet = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			//packet.setSoTimeout(2000);
			Socket packet = new Socket();
			packet.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13),2000);
			InputStream inStream = packet.getInputStream();
			Scanner in = new Scanner(inStream);
			
			while(in.hasNext())
			{
				String line = in.nextLine();
				System.out.print(line);
			}
		}
		catch(InterruptedIOException e){
			System.out.print("time out\n");
		}
		finally{
			
		}
	}

}
