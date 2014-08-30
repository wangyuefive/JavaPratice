package ProcessTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ProcessTest {
	
	public static void main(String[] args) throws Exception{
		Process process =  Runtime.getRuntime().exec("ipconfig");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line=bufferedReader.readLine()) != null) {
		    System.out.println(line);
		}
		Process process2 =  Runtime.getRuntime().exec("D:/a.bat");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));
		bw.write("hello");
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
