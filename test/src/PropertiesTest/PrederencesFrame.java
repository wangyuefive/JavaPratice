package PropertiesTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.log4j.Logger;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class PrederencesFrame extends JFrame{
	
	private static final long serialVersionUID = 5722967517046363899L;
	private Logger log = Logger.getLogger(PropertiesTest.class);
	
	public  PrederencesFrame(){
		
		Preferences root = Preferences.userRoot();
		final Preferences node = root.node("/com/wangyue");
		log.info(node);
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", 300);
		int height = node.getInt("height", 200);
		setBounds(left, top, width, height);
		
		String title = node.get("title", " ");
		if(title.equals(""))
			title = JOptionPane.showInputDialog("«Î ‰»Î“ª∏ˆtitle");
		if(title ==null)
			title = "";
		setTitle(title);
		
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		FileFilter mp3filter = new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "mp3";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".mp3") || f.isDirectory();
			}
		};
		chooser.setFileFilter(new FileFilter() {
			
			public String getDescription() {
				return "XML files";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".xml") ||f.isDirectory();
			}
		});
		chooser.addChoosableFileFilter(mp3filter);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem exportItem = new JMenuItem("Export Perferences");
		menu.add(exportItem);
		exportItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chooser.showSaveDialog(PrederencesFrame.this) == JFileChooser.APPROVE_OPTION){
					try{
						OutputStream out = new FileOutputStream(chooser.getSelectedFile());
						node.exportSubtree(out);
						out.close();
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem importItem = new JMenuItem("Import Perferences");
		menu.add(importItem);
		importItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chooser.showSaveDialog(PrederencesFrame.this) == JFileChooser.APPROVE_OPTION){
					try{
						InputStream in = new FileInputStream(chooser.getSelectedFile());
						Preferences.importPreferences(in);
						in.close();
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				node.putInt("left", getX());
				node.putInt("top", getY());
				node.putInt("width", getWidth());
				node.putInt("height", getHeight());
				node.put("title", getTitle());
				System.exit(0);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				node.putInt("left", getX());
				node.putInt("top", getY());
				node.putInt("width", getWidth());
				node.putInt("height", getHeight());
				node.put("title", getTitle());
				System.exit(0);
			}
		});
	}

}
