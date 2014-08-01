package ImageTest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//一个定制的图像标签类  
public class ImageLabel extends JLabel 
{ 
//      public ImageButon(String img)  
//      {  
//          this(new ImageIcon(img));  
//      }  
  public ImageLabel(ImageIcon icon) 
  { 
      //设置标签尺寸以匹配图像大小  
      setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null)); 
      //设置图标，把绘图工作交给了JLabel  
      setIcon(icon); 
      //将图标文本间隙设为0，边框和文字为null，这样可消除图像周围多余的空间  
      setIconTextGap(0); 
      setBorder(null); 
      setText(null); 
      //告诉标签不要绘制自己的背景。如果图像含有透明部分，这使得背景图案可以透过透明部分。  
      setOpaque(false); 
  } 
} 
