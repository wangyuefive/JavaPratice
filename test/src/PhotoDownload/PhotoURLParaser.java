package PhotoDownload;

import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class PhotoURLParaser implements Runnable{

	private Logger log = Logger.getLogger(PhotoURLParaser.class);
	
	private BlockingQueue<String> urllist = null ; //图片的的URL阻塞队列
	
	private String webHTML = null;  //网页的文本信息
	
	private String regex = null ; //从webHTML挑出图片的连接的正则表达式
	
	public PhotoURLParaser(BlockingQueue<String> list , String html , String regex){
		this.urllist = list;
		this.webHTML = html;
		this.regex = regex;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(null == urllist || null == webHTML || null == regex){
			log.info("webHTML or regex or urllist is null");
			return;
		}
		Pattern pattern = Pattern.compile(this.regex);
		Matcher matcher = pattern.matcher(webHTML);
		while(matcher.find()){
			int begin = matcher.start();
			int end = matcher.end();
			String url = webHTML.substring(begin, end);
			log.info(url);
			boolean done = false;
			while(!done){
				try {
					urllist.put(url);  //加入队列
					done =true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(int i = 0 ; i < 2*PhotoDownload.DownLoadThreadCount ; i++){
			boolean done = false;
			while(!done){
				try {
					urllist.put("exit");  //加入队列 ,在线程取出exit的字符的时候，线程退出
					done =true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
