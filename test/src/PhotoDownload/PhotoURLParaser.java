package PhotoDownload;

import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class PhotoURLParaser implements Runnable{

	private Logger log = Logger.getLogger(PhotoURLParaser.class);
	
	private BlockingQueue<String> urllist = null ; //ͼƬ�ĵ�URL��������
	
	private String webHTML = null;  //��ҳ���ı���Ϣ
	
	private String regex = null ; //��webHTML����ͼƬ�����ӵ�������ʽ
	
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
					urllist.put(url);  //�������
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
					urllist.put("exit");  //������� ,���߳�ȡ��exit���ַ���ʱ���߳��˳�
					done =true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
