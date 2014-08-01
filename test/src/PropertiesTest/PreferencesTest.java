package PropertiesTest;

import java.awt.EventQueue;
import java.io.File;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class PreferencesTest {
	private static Logger log = Logger.getLogger(PreferencesTest.class);
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PrederencesFrame frame = new PrederencesFrame();
				frame.setVisible(true);
			}
		});
	}
}


