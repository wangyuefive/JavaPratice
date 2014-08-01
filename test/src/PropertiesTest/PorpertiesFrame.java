package PropertiesTest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class PorpertiesFrame extends JFrame{

	private static final long serialVersionUID = -3650036865776093342L;
	
	private Logger log = Logger.getLogger(PropertiesTest.class);
	
	private File propertiesFile;
	private Properties setting;
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public PorpertiesFrame()
	{
		log.info(System.getProperty("java.version"));
		log.info(System.getProperty("java.vendor"));
		log.info(System.getProperty("java.class.version"));
		log.info(System.getProperty("os.version"));
		log.info(System.getProperty("os.name"));
		log.info(System.getProperty("os.arch"));
		log.info(System.getProperty("file.separator"));
		log.info(System.getProperty("path.separator"));
		log.info(System.getProperty("line.separator"));
		String userDir = System.getProperty("user.home");
		log.info(userDir);
		File propertiesDir = new File(userDir,".corejava");
		log.info(propertiesDir);
		if(!propertiesDir.exists())
			propertiesDir.mkdir();
		propertiesFile = new File(propertiesDir, "program.properties");
		
		Properties defaultSettings = new Properties();
		defaultSettings.put("left", "0");
		defaultSettings.put("top", "0");
		defaultSettings.put("width", ""+DEFAULT_WIDTH);
		defaultSettings.put("height", ""+DEFAULT_HEIGHT);
		defaultSettings.put("title", "Default titles");
		
		setting = new Properties(defaultSettings);
		
		if(propertiesFile.exists()){
			try{
				FileInputStream in = new FileInputStream(propertiesFile);
				setting.load(in);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
			
		int left = Integer.parseInt(setting.getProperty("left"));
		int top = Integer.parseInt(setting.getProperty("top"));
		int width = Integer.parseInt(setting.getProperty("width"));
		int height = Integer.parseInt(setting.getProperty("height"));
		setBounds(left, top, width, height);
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				setting.put("left", ""+getX());
				setting.put("top", ""+getY());
				setting.put("width", ""+getWidth());
				setting.put("height", ""+getHeight());
				try{
					FileOutputStream  out = new FileOutputStream(propertiesFile);
					setting.store(out, "Program Properties");
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
