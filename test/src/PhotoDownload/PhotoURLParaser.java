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
	
	/**
	 * @param list  ��������
	 * @param html  ��ҳhtml��Դ�ļ�
	 * @param regex ��Ҫ�жϵ�λ��HTML��ͼƬ���ӵ�������ʽ
	 */
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
		log.info("==-----regex =" + regex);
		while(matcher.find()){
			int begin = matcher.start();
			int end = matcher.end();
			String url = webHTML.substring(begin, end);
			url = url.substring(1, url.length()-1);
			boolean done = false;
			while(!done){
				try {
					urllist.put(url);  //�������
					log.info("------>"+url);
					done =true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(int i = 0 ; i < PhotoDownload.DownLoadThreadCount ; i++){
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
