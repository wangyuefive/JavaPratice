package ImageTest;

import javax.swing.*; 
import java.awt.*; 
 
public class ImagePanel extends JPanel{ 
    private Image img; 
    //一个JPanel的定制子类  
    public ImagePanel(Image img) 
    { 
        this.img = img; 
        Dimension size = new Dimension(img.getWidth(null),img.getHeight(null)); 
        setSize(size); 
        //确保面板大小与图像一致  
        setPreferredSize(size); 
        setMinimumSize(size); 
        setMaximumSize(size); 
        setLayout(null); 
    } 
    //重写绘制图像方法  
    public void paintComponent(Graphics g) 
    { 
        g.drawImage(img, 0, 0, null); 
    } 
 
 
    //测试  
    public static void main(String[] args) 
    { 
        ImagePanel panel = new ImagePanel(new ImageIcon("G:/图片/壁纸/03.jpg").getImage()); 
        ImageLabel label = new ImageLabel(new ImageIcon("D:/SS3000-S平台/20080906221809543.png")); 
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        FileDocumentButton fileButton1 = new FileDocumentButton("汪月的未来是精彩的") ;
        FileDocumentButton fileButton2 = new FileDocumentButton("史庆超") ;
        panel.add(fileButton1);
        panel.add(fileButton2);
       // panel.add(label); 
        final ImageButton button = new ImageButton(new ImageIcon("D:/SS3000-S平台/4kongcom-0007.png")); 
        //panel.add(button); 
 
        //为按钮添加按下、选中、失效等状态的效果  
        button.setPressedIcon(new ImageIcon("G:/20080906221809543.png")); 
        button.setSelectedIcon(new ImageIcon("G:/4kongcom-0005.png")); 
        button.setText("ssss");
 
        JFrame frame = new JFrame("汪月:Creat ImagePanel"); 
        frame.getContentPane().add(panel); 
        frame.pack(); 
        frame.setVisible(true); 
    } 
} 