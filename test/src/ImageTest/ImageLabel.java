package ImageTest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//һ�����Ƶ�ͼ���ǩ��  
public class ImageLabel extends JLabel 
{ 
//      public ImageButon(String img)  
//      {  
//          this(new ImageIcon(img));  
//      }  
  public ImageLabel(ImageIcon icon) 
  { 
      //���ñ�ǩ�ߴ���ƥ��ͼ���С  
      setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null)); 
      //����ͼ�꣬�ѻ�ͼ����������JLabel  
      setIcon(icon); 
      //��ͼ���ı���϶��Ϊ0���߿������Ϊnull������������ͼ����Χ����Ŀռ�  
      setIconTextGap(0); 
      setBorder(null); 
      setText(null); 
      //���߱�ǩ��Ҫ�����Լ��ı��������ͼ����͸�����֣���ʹ�ñ���ͼ������͸��͸�����֡�  
      setOpaque(false); 
  } 
} 
