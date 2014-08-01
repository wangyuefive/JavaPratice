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
		JButton btn_start = new JButton("开始");
		JButton btn_stop = new JButton("停止");
		btnPanel.add(btn_start);
		btnPanel.add(btn_stop);
		btn_start.addActionListener(act_start);
		btn_stop.addActionListener(act_stop);
		this.add(btnPanel);
		this.setSize(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Thread t = null;
	private int threadStatus = 0 ; //0 未启动， 1 已启动
	
	private ActionListener act_start = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(null == t || threadStatus == 0){
				t = new Thread(new myTimer());   
				t.start();    //启动线程
				t.setDefaultUncaughtExceptionHandler(new myUnCaughtExceptionHandler());
				threadStatus = 1;
				log.info("线程已经启动");	
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
			log.info("你看，被我抓到了吧！！");
		}
		
	}
	class myTimer implements Runnable{
		
		public void run(){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			try{
				while(true){
					log.info(df.format(new Date()));
					log.info(Thread.currentThread().getState());
					Thread.sleep(1000);
				}	
			}catch(InterruptedException e1)
			{
				log.info("线程停止");
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
