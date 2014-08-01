package IOtest;

import java.io.File;

public class IOtest {
	public final static String VOICEMAIL_ROOT_PATH = "D:/default";  //�������������Ը�Ŀ¼
	
	public static void findTxtInfo(File file)
	{
		if(file.isDirectory())
		{
			File[] files = file.listFiles();
			for(File fs: files)
			findTxtInfo(fs);
		}
		else if(file.isFile() && file.getAbsolutePath().endsWith(".txt")){
			System.out.println("==="+file.getAbsolutePath());
			}	
	}
	
	public static void main(String[] args)
	{
		File root = new File(VOICEMAIL_ROOT_PATH);  //��Ŀ¼
		findTxtInfo(root);  //�ݹ����
	}
}
