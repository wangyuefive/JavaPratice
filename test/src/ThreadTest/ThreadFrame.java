package ThreadTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

/***
 * @author wangyue
 */
public class ThreadFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger(ThreadFrame.class);

	public ThreadFrame() {
		JPanel btnPanel = new JPanel();
		JButton btn_start = new JButton("��ʼ");
		JButton btn_stop = new JButton("ֹͣ");
		btnPanel.add(btn_start);
		btnPanel.add(btn_stop);
		btn_start.addActionListener(act_start);
		btn_stop.addActionListener(act_stop);
		this.add(btnPanel);
		this.setSize(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Thread t = null;
	private int threadStatus = 0 ; //0 δ������ 1 ������
	
	private ActionListener act_start = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(null == t || threadStatus == 0){
				t = new Thread(new myTimer());   
				t.start();    //�����߳�
				t.setDefaultUncaughtExceptionHandler(new myUnCaughtExceptionHandler());
				threadStatus = 1;
				log.info("�߳��Ѿ�����");	
			}
		}
	};
	
	private ActionListener act_stop = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(null != t && threadStatus == 1){
				t.interrupt();	
				threadStatus = 0 ;
			}
		}
	};
	
	class myUnCaughtExceptionHandler implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// TODO Auto-generated method stub
			log.info("�㿴������ץ���˰ɣ���");
		}
		
	}
	class myTimer implements Runnable{
		
		public void run(){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			try{
				while(true){
					log.info(df.format(new Date()));
					log.info(Thread.currentThread().getState());
					Thread.sleep(1000);
				}	
			}catch(InterruptedException e1)
			{
				log.info("�߳�ֹͣ");
				//throw new EOFException();
			} 
		}	
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ThreadFrame frame = new ThreadFrame();
				frame.setLocation(500, 100);
				frame.setVisible(true);
			}
		});
	}

}
