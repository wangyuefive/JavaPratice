package JavaBean;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class imageViewer extends JLabel {

	private static final long serialVersionUID = 1600395224855720314L;

	private String path = null;
	
	private static final int XREFSIZE = 200;
	private static final int YREFSIZE = 200;
	
	public imageViewer(){
		this.setBorder(BorderFactory.createEtchedBorder());
	}
	
	public void setFileName(String file){
		this.path = file ;
		try {
			InputStream in = new FileInputStream(new File(file));
			this.setIcon(new ImageIcon(ImageIO.read(in)));
		} catch (Exception e) {
			// TODO: handle exception
			path = null;
			this.setIcon(null);
		}
	}
	
	public String getFileName(){
		if(path == null)
			return null;
		else
			return path ;
	}
	
	public Dimension getPreferSize(){
		return new Dimension(XREFSIZE,YREFSIZE);
	}
}
