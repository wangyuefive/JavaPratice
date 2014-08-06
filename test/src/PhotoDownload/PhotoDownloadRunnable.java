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
	
	private BlockingQueue<String> urllist = null ; //ͼƬ�ĵ�URL��������
	
	private String path = null;
	
	private long minSize = 0 ;
	
	/**
	 * @param list  ͼƬ���ӵĶ���
	 * @param doc   ��Ҫ����ͼƬ���ļ��еĵ�ַ
	 * @param min : ͼƬ����С�ߴ�  ��λ byte;
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
			while(!(urlstr=getURL()).equals("exit")){  //�����exit�ַ������˳��߳�
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
				//������е�Ӱ�����ܣ���Ϊ�����ز�����֮�����ж��ļ���С�Ƿ���ϵ�
				if(count < minSize ){   //�ļ���С������ɾ��
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
					JOptionPane.showMessageDialog(null,"�������");
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
	 *�ӵ�ǰ��URL�л�ȡ�ļ�������
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
