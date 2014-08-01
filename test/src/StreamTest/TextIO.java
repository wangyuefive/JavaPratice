package StreamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.charset.*;


public class TextIO {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
	
		InputStreamReader file = new InputStreamReader(new FileInputStream(new File("D:/text.txt")));
		BufferedReader in = new BufferedReader(file);
		String line ;
		while((line = in.readLine())!=null)
		{
			System.out.println(line);
		}
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("D:/123.txt")));
		ArrayList<String> str = new ArrayList<String>();
		str.add("wangyuefive@163.com");
		str.add("wanyue");
		out.writeObject(str);
		out.close();
		
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(new File("D:/123.txt")));
		ArrayList<String> stri = (ArrayList<String>) in2.readObject();
		for(String mm : stri)
			System.out.println(mm);
		in2.close(); 
		
		String data1 = "07/11/14 10:21:30 AM"	;
		String data2 = "07/11/14 04:01:30 PM"	;
		System.out.println("======"+compareDate(data1, data2));	
		
		
		File fs = new File("D:/test.txt");
		if(!fs.exists()){
			fs.createNewFile();
		}
		PrintWriter out1 = new PrintWriter(fs);
		out1.println("wangyuewangyue");
		out1.println("wangyuewangyue");
		out1.println("wangyuewangyue");
		out1.close();
		InputStreamReader in1 = new InputStreamReader(new FileInputStream(fs));
		BufferedReader bufferin = new BufferedReader(in1);
		String line1;
		if((line1=bufferin.readLine()) !=null)
			System.out.println(line1);
		bufferin.close();
			
	}	
	
	/**
	 * 日期格式: 07/11/14 04:15:30 PM
	 * @param srcDate 
	 * @param dstDate
	 * @return
	 */
	private static int compareDate(String srcDate, String dstDate){
		if(srcDate.substring(6, 8).compareTo(dstDate.substring(6,8)) > 0)  //年
			return 1;
		if(srcDate.substring(0, 6).compareTo(dstDate.substring(0, 6)) > 0) //月日
			return 1;
		if(srcDate.substring(18, 19).compareTo(dstDate.substring(18, 19)) > 0) //上午下午
			return 1;
		if(srcDate.substring(9, 17).compareTo(dstDate.substring(9, 17)) > 0) //上午下午
			return 1;
		return -1;
	}
}

