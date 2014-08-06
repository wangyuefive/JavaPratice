package PhotoDownload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class PhotoDownloadRunnable implements Runnable{
	
	private Logger log = Logger.getLogger(PhotoURLParaser.class);
	
	private BlockingQueue<String> urllist = null ; //图片的的URL阻塞队列
	
	private String path = null;
	
	private long minSize = 0 ;
	
	/**
	 * @param list  图片链接的队列
	 * @param doc   需要保存图片的文件夹的地址
	 * @param min : 图片的最小尺寸  单位 byte;
	 */
	public PhotoDownloadRunnable(BlockingQueue<String> list, String docPath , long min){
		this.urllist = list;
		this.path = docPath;
		this.minSize = min;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String urlstr = null;
		log.info("Thread "+Thread.currentThread().getId()+ " Downlaod is running");
		try {
			while(!(urlstr=getURL()).equals("exit")){  //如果是exit字符串则退出线程
				String filename = getFileName(urlstr);
				String fileAbsolutePath = path + "/"+filename;
				File file = new File(fileAbsolutePath);
				if(!file.exists())
					file.createNewFile();
				
				URL url = new URL(urlstr);
				InputStream in  = url.openStream();
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				int read = 0 ;
				int count = 0;
				while((read = in.read())!=-1){
					out.write(read);
					count++;
				}
				in.close();
				out.close();
				//这可能有点影响性能，因为是下载并保存之后在判断文件大小是否符合的
				if(count < minSize ){   //文件大小不符，删除
					file.delete();
				}	
			} 
			log.info("Thread "+Thread.currentThread().getId()+" is exit!");
			
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	private String getURL(){
		if(urllist == null){
			log.info("urllist can not be null ");
			return null;
		}
		String url = null;
		boolean done =false ;
		while(!done){
			try {
				url = urllist.take();
				done =true;
				if(urllist.size() == 0 && url.equals("exit")){
					JOptionPane.showMessageDialog(null,"下载完毕");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return url ;
	}
	
	private int i = 0;
	/**
	 *从当前的URL中获取文件的名称
	 */
	private String getFileName(String url){
		String name =null;
		String regex = "/[^/]*.(jpg)|(JPG)|(gif)|(GIF)|(png)|(PNG)|(BMP)|(bmp)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		String pre = ""+(i++)+"_";
		if(matcher.find()){
			int begin = matcher.start()+1;
			int end = matcher.end();
			name = pre + url.substring(begin, end);
		}
		return name;
	}

}
