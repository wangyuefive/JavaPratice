package PhotoDownload;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * һ����ҳͼƬ��������
 * @author wangyue
 *
 */
public class PhotoDownload extends JFrame{
	
	private Logger log = Logger.getLogger(PhotoDownload.class); 
	
	private JTextField urlText = new JTextField();
	
	private JTextField sizeText = new JTextField();
	
	private JFileChooser chooser = new JFileChooser(new File("."));
	private JTextField docSelectText = new JTextField(System.getProperty("user.dir"));
	private JButton btn_fileselect = new JButton("ѡ��");
	
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
		this.setTitle("ͼƬ������");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		
		Box hbox1 = Box.createHorizontalBox();
		JLabel lbl_url = new JLabel("������ַ��");
		this.setComSize(lbl_url, 80, 25);
		this.setComSize(urlText, 380, 25);
		hbox1.add(lbl_url);
		hbox1.add(urlText);
		urlText.setText("http://tjholowaychuk.com/scenery");
		
		Box hbox2 = Box.createHorizontalBox();
		JLabel lbl_photoType = new JLabel("ͼƬ��ʽ��");
		this.setComSize(lbl_photoType, 80, 25);
		box_bmp.addActionListener(boxlistener);
		box_jpg.addActionListener(boxlistener);
		box_gif.addActionListener(boxlistener);
		box_png.addActionListener(boxlistener);
		box_all.addActionListener(boxAllListener);
		box_all.setSelected(true);
		hbox2.add(lbl_photoType);
		hbox2.add(box_jpg);
		hbox2.add(box_gif);
		hbox2.add(box_bmp);
		hbox2.add(box_png);
		hbox2.add(box_all);
		hbox2.add(Box.createHorizontalStrut(150));
		
		Box hbox3 = Box.createHorizontalBox();
		JLabel lbl_sizelimit = new JLabel("ͼƬ��С��");
		JLabel lbl_unit = new JLabel("KB");
		this.setComSize(lbl_sizelimit, 80, 25);
		this.setComSize(sizeText, 80, 25);
		this.setComSize(lbl_unit, 300, 25);
		sizeText.setSize(15,300);
		sizeText.setToolTipText("ֻ����������");
		hbox3.add(lbl_sizelimit);
		hbox3.add(sizeText);
		hbox3.add(lbl_unit);
		sizeText.setText("100");
		
		Box hbox4 = Box.createHorizontalBox();
		JLabel lbl_StoreTo = new JLabel("��������");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		docSelectText.setText(System.getProperty("user.dir"));
		btn_fileselect.setBounds(0, 0, 0, 0);
		btn_fileselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showDialog(btn_fileselect, "ȷ��");
				if(result == JFileChooser.APPROVE_OPTION);
				docSelectText.setText(chooser.getSelectedFile().getAbsolutePath());		
			}
		});
		this.setComSize(lbl_StoreTo, 80, 25);
		this.setComSize(docSelectText, 300, 25);
		this.setComSize(btn_fileselect, 80, 25);
		hbox4.add(lbl_StoreTo);
		hbox4.add(docSelectText);
		hbox4.add(btn_fileselect);
		
		Box hbox5 = Box.createHorizontalBox();
		JButton btn_load = new JButton("����");
		btn_load.setFocusPainted(false);
		btn_load.addActionListener(act_download);
		hbox5.add(btn_load);
		
		pnl.add(Box.createVerticalStrut(20));
		pnl.add(hbox1);
		pnl.add(Box.createVerticalStrut(20));
		pnl.add(hbox2);
		pnl.add(Box.createVerticalStrut(20));
		pnl.add(hbox3);
		pnl.add(Box.createVerticalStrut(20));
		pnl.add(hbox4);
		pnl.add(Box.createVerticalStrut(20));
		pnl.add(hbox5);
		pnl.add(Box.createVerticalStrut(20));
		
		this.add(pnl);	
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
	
	private ActionListener act_download = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String url = urlText.getText();
			if(!url.startsWith("http")){  //��ȡurl
				url = "http://"+url ;
			}
			log.info("url = "+ url);
			String html = getWebText(url);  //ԭʼHTML WEB�ļ� 
			log.info(html.substring(0, 100));
			String regex = createRegex();  //regex
			String size = sizeText.getText();
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher matcher = pattern.matcher(size);
			if(!matcher.matches()){
				JOptionPane.showMessageDialog(PhotoDownload.this, "ͼƬ��Сֻ��Ϊ���֣�");
				return ;
			}
			long limit = 0;   //Ĭ�ϴ�С
			if(size!=null && !size.equals("")){
				limit = Integer.parseInt(size) * 1024;
			}
			String path = docSelectText.getText();   //path
			Pattern pattern2 = Pattern.compile("^[A-Za-z]:\\\\[^\\s]*");
			Matcher matcher2 = pattern2.matcher(path);
			if(!matcher2.matches()){
				JOptionPane.showMessageDialog(PhotoDownload.this, "������ļ�·�����ܰ�������·��");
				return ;
			}
			log.info("regex = "+ regex + " \npath = "+ path + " \nlimit = "+ limit +"byte");
			startParaserThread(photoUrlList, html, regex);
			startDownLoadThread(photoUrlList, path, limit);
		}
	};
	
	/**
	 * ����WEB��ҳ��������
	 * @param list
	 * @param html
	 * @param regex
	 */
	private void startParaserThread(BlockingQueue<String> list , String html , String regex){
		
		PhotoURLParaser paraser = new PhotoURLParaser(list, html, regex);
		Thread thread = new Thread(paraser);
		thread.start();
	}
	
	private void startDownLoadThread(BlockingQueue<String> list, String docPath , long min){
		PhotoDownloadRunnable download = new PhotoDownloadRunnable(list, docPath, min);
		for(int i=0; i < DownLoadThreadCount ; i++ ){
			Thread thread = new Thread(download);
			thread.start();
		}
	}
	private void setComSize(Component component, int width ,int height){
		component.setPreferredSize(new Dimension(width, height));
		component.setMinimumSize(new Dimension(width, height));
		component.setMaximumSize(new Dimension(width, height));
		component.setSize(new Dimension(width, height));
	}
	
	/**
	 * URL�ĵ�������������ҳ
	 * @param url
	 * @return
	 */
	private String getWebText(String url){
		try {
			InputStreamReader in = new InputStreamReader(new URL(url).openStream(),"UTF-8"); //�����ַ���
			StringBuilder input = new StringBuilder();
			int ch;
			while((ch=in.read())!=-1){
				input.append((char)ch);   //ע��˴���һ�� char��ǿ��ת������
			}		
			return input.toString();
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(PhotoDownload.this, "����WEB��ַ�Ƿ���ȷ");
			e.printStackTrace();	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(PhotoDownload.this, "����WEB��ַ�Ƿ���ȷ");
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
		EventQueue.invokeLater(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PhotoDownload frame = new PhotoDownload();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation((size.width-frame.getWidth())/2, (int) ((size.getHeight()-frame.getHeight())/2));
				frame.setVisible(true);			
			}
		});
	}
}
