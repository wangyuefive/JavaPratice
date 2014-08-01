package PropertiesTest;

import java.awt.EventQueue;
import java.io.File;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class PropertiesTest {
	private static Logger log = Logger.getLogger(PropertiesTest.class);
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PorpertiesFrame frame = new PorpertiesFrame();
				frame.setVisible(true);
			}
		});
	}
}


