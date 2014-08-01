package RegxTest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temptest {
	
	public static void main(String[] args) throws Exception{
		String str = "src=\"http://icon.fengniao.com/forum2012/images/bbsUpgradePost04.jpg\"/>";
		String jpg_regex = "http[^\"]*\\.jpg";
		Pattern pattern = Pattern.compile(jpg_regex);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			String mm = str.substring(start,end);
			System.out.println(mm);
		}
		
		/**
		 * 测试读取一个网页上面的图片
		 */
		URL url = new URL("http://img3.douban.com/view/commodity_story/medium/public/p7329874.jpg");
		InputStream in = url.openStream();
		File tofile = new File("D://123.jpg");
		if(!tofile.exists())
			tofile.createNewFile();
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tofile));
		int bytesRead = 0;
        while((bytesRead = in.read())!=-1){
          out.write(bytesRead);
        }
		in.close();
		out.close();
		
	}
	
	 private static long getFileSizes(File f) throws Exception{//取得文件大小
	        long s=0;
	        if (f.exists()) {
	            FileInputStream fis = null;
	            fis = new FileInputStream(f);
	           s= fis.available();
	        } else {
	            f.createNewFile();
	            System.out.println("文件不存在");
	        }
	        return s;
	    }
        

}
