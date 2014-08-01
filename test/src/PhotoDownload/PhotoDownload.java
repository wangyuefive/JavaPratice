package PhotoDownload;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class PhotoDownload extends JFrame{
	
	private Logger log = Logger.getLogger(PhotoDownload.class); 
	
	private JTextField urlText = new JTextField();
	
	private JFileChooser docChooser = new JFileChooser(new File(System.getProperty("user.dir")));
	
	private JCheckBox box_png = new JCheckBox("png");
	private JCheckBox box_jpg = new JCheckBox("jpg");
	private JCheckBox box_bmp = new JCheckBox("bmp");
	private JCheckBox box_gif = new JCheckBox("gif");
	
	private static final String jpg_regex = "\"http[^\"]*\\.jpg\"";
	private static final String gif_regex = "\"http[^\"]*\\.gif\"";
	private static final String png_regex = "\"http[^\"]*\\.png\"";
	private static final String bmp_regex = "\"http[^\"]*\\.bmp\"";
	
	public static final int QUEUE_SIZE = 100;   //队列容量
	public static final int DownLoadThreadCount = 10;  //开启的下载线程数
	
	private BlockingQueue<String> photoUrlList = new ArrayBlockingQueue<String>(QUEUE_SIZE);  //图片文件的连接
	
	public PhotoDownload(){
		this.setTitle("PhotoDownload");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pnl = new JPanel();
		
		JLabel lbl_url = new JLabel("网址：");
		Box hbox1 = Box.createHorizontalBox();
		hbox1.add(lbl_url);
		hbox1.add(urlText);
		
		JLabel lbl_photoType = new JLabel("图片格式");
		JCheckBox box_png = new JCheckBox("png");
		JCheckBox box_jpg = new JCheckBox("jpg");
		JCheckBox box_bmp = new JCheckBox("bmp");
		JCheckBox box_gif = new JCheckBox("gif");
	}
	
	/**
	 * URL文档解析，返回网页
	 * @param url
	 * @return
	 */
	private String getWebText(String url){
		try {
			InputStreamReader in = new InputStreamReader(new URL(url).openStream(),"UTF-8");
			StringBuilder input = new StringBuilder();
			char ch;
			while((ch=(char)in.read())!=-1){
				input.append(ch);
			}
			return input.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 生成Regex正则表达式
	 * @return
	 */
	private String createRegex(){
		String regex = null;
		if(box_bmp.isSelected())
			regex = 
	}
	
	
	
	

}
