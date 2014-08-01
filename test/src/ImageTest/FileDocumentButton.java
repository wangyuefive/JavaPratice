package ImageTest;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class FileDocumentButton extends JButton{

	private static final long serialVersionUID = -4623892065369807316L;
	
	private ImageIcon DocumentIcon;
	private ImageIcon DocumentOpenIcon;
	
	public FileDocumentButton(String aDocumentName){
		super(aDocumentName);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);//按键透明
		this.initImageIcon("images/document.png", "images/documentopen.png");
		this.setIcon(DocumentIcon);
		setMaximumSize(new Dimension(100, 130));
	    setMinimumSize(new Dimension(100, 130));
	    setPreferredSize(new Dimension(100, 130));
	    setSize(100, 130) ;
	    this.setBorderPainted(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				FileDocumentButton.this.setIcon(DocumentOpenIcon);
				FileDocumentButton.this.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				FileDocumentButton.this.setIcon(DocumentIcon);
				FileDocumentButton.this.setBorderPainted(false);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}				
		});
	}
	
	private void initImageIcon(String document,String documentopen){
	    try {
            DocumentIcon = new ImageIcon(ImageIO.read(new File("D:/SS3000-S平台/document.png"))) ;
            DocumentOpenIcon = new ImageIcon(ImageIO.read(new File("D:/SS3000-S平台/documentopen.png")));      
        } catch( Exception e ) {
            e.printStackTrace() ;
        }
	}
	

}