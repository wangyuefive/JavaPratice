package ImageTest;

import java.awt.*; 
import javax.swing.*; 
 
 
    //��������ͼ��İ�ť  
public class ImageButton extends JButton 
{ 
    public ImageButton(ImageIcon icon) 
    { 
        setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null)); 
        setIcon(icon); 
        setMargin(new Insets(0,0,0,0)); 
        setIconTextGap(0); 
        setBorderPainted(false); 
        setBorder(null); 
        setText(null); 
    } 
}