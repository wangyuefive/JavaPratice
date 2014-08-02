package PhotoDownload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.BoxLayout;
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
	private JCheckBox box_all = new JCheckBox("ȫ��");
	private JCheckBox box_png = new JCheckBox("png");
	private JCheckBox box_jpg = new JCheckBox("jpg");
	private JCheckBox box_bmp = new JCheckBox("bmp");
	private JCheckBox box_gif = new JCheckBox("gif");
	
	private static final String jpg_regex = "\"http[^\"]*\\.jpg\"";
	private static final String gif_regex = "\"http[^\"]*\\.gif\"";
	private static final String png_regex = "\"http[^\"]*\\.png\"";
	private static final String bmp_regex = "\"http[^\"]*\\.bmp\"";
	
	public static final int QUEUE_SIZE = 100;   //��������
	public static final int DownLoadThreadCount = 10;  //�����������߳���
	
	private BlockingQueue<String> photoUrlList = new ArrayBlockingQueue<String>(QUEUE_SIZE);  //ͼƬ�ļ�������
	
	public PhotoDownload(){
		this.setTitle("PhotoDownload");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		
		JLabel lbl_url = new JLabel("��ַ��");
		lbl_url.setSize(20,100);
		Box hbox1 = Box.createHorizontalBox();
		urlText.setSize(20,300);
		hbox1.add(lbl_url);
		hbox1.add(urlText);
		
		Box hbox2 = Box.createHorizontalBox();
		JLabel lbl_photoType = new JLabel("ͼƬ��ʽ");
		lbl_photoType.setSize(20,100);
		hbox2.add(box_jpg);
		hbox2.add(box_gif);
		hbox2.add(box_bmp);
		hbox2.add(box_png);
		hbox2.add(box_all);
		box_bmp.addActionListener(boxlistener);
		box_jpg.addActionListener(boxlistener);
		box_gif.addActionListener(boxlistener);
		box_png.addActionListener(boxlistener);
		box_all.addActionListener(boxAllListener);
		hbox2.add(lbl_photoType);
		hbox2.add(box_jpg);
		hbox2.add(box_gif);
		hbox2.add(box_bmp);
		hbox2.add(box_png);
		hbox2.add(box_all);
		
		Box hbox3 = Box.createHorizontalBox();
		JLabel labl_sizelimit = new JLabel("ͼƬ��С��");
		
		
	}
	
	private ActionListener boxAllListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			box_png.setSelected(false);
			box_jpg.setSelected(false);
			box_gif.setSelected(false);
			box_bmp.setSelected(false);
		}
	};
	
	private ActionListener boxlistener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			box_all.setSelected(false);
		}
	};
	
	/**
	 * URL�ĵ�������������ҳ
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
	 * ���ݽ���ѡ������Regex������ʽ
	 * @return
	 */
	private String createRegex(){
		String regex = "";
		ArrayList<String> list = new ArrayList<String>();
		if(box_all.isSelected()){  //ȫѡ
			regex = jpg_regex + "|" +gif_regex +"|" + bmp_regex+"|" + png_regex;
		}
		else{
			if(box_jpg.isSelected())
				list.add(jpg_regex);
			if(box_bmp.isSelected())
				list.add(bmp_regex);
			if(box_png.isSelected())
				list.add(png_regex);
			if(box_gif.isSelected())
				list.add(gif_regex);
			for(int i =0 ; i < list.size(); i++){
				regex = list.get(i) + "|";
			}
			regex = regex.substring(0,regex.length()-1);  //ȥ�����һ�� ��|��
		}
		return regex;
	}
	
	public static void main(String[] args){
		
	}
}
