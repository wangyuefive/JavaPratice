package PhotoDownload;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class PhotoDownloadRunnable implements Runnable{
	
	private Logger log = Logger.getLogger(PhotoURLParaser.class);
	
	private BlockingQueue<String> urllist = null ; //图片的的URL阻塞队列
	
	private String path = null;
	
	private long minSize = 0 ;
	
	private long maxSize = 0 ;
	
	/**
	 * @param list 图片链接的队列
	 * @param doc  需要保存图片的文件夹的地址
	 * @param min max : 图片的大小的范围  单位 byte;
	 */
	public PhotoDownloadRunnable(BlockingQueue<String> list, String docPath , long min, long max){
		this.urllist = list;
		this.path = docPath;
		this.maxSize =max;
		this.minSize = min;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String urlstr = null;
		while(!(urlstr=getURL()).equals("exit")){  //如果是exit字符串则退出线程
			try {
				String filename = getFileName(urlstr);
				URL url = new URL(urlstr);
				InputStream in  = url.openStream();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return url ;
	}
	
	/**
	 *从当前的URL中获取文件的名称
	 */
	private String getFileName(String url){
		String name =null;
		
		return name;
	}

}
