package ImageTest;

import javax.swing.*; 
import java.awt.*; 
 
public class ImagePanel extends JPanel{ 
    private Image img; 
    //һ��JPanel�Ķ�������  
    public ImagePanel(Image img) 
    { 
        this.img = img; 
        Dimension size = new Dimension(img.getWidth(null),img.getHeight(null)); 
        setSize(size); 
        //ȷ������С��ͼ��һ��  
        setPreferredSize(size); 
        setMinimumSize(size); 
        setMaximumSize(size); 
        setLayout(null); 
    } 
    //��д����ͼ�񷽷�  
    public void paintComponent(Graphics g) 
    { 
        g.drawImage(img, 0, 0, null); 
    } 
 
 
    //����  
    public static void main(String[] args) 
    { 
        ImagePanel panel = new ImagePanel(new ImageIcon("G:/ͼƬ/��ֽ/03.jpg").getImage()); 
        ImageLabel label = new ImageLabel(new ImageIcon("D:/SS3000-Sƽ̨/20080906221809543.png")); 
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        FileDocumentButton fileButton1 = new FileDocumentButton("���µ�δ���Ǿ��ʵ�") ;
        FileDocumentButton fileButton2 = new FileDocumentButton("ʷ�쳬") ;
        panel.add(fileButton1);
        panel.add(fileButton2);
       // panel.add(label); 
        final ImageButton button = new ImageButton(new ImageIcon("D:/SS3000-Sƽ̨/4kongcom-0007.png")); 
        //panel.add(button); 
 
        //Ϊ��ť��Ӱ��¡�ѡ�С�ʧЧ��״̬��Ч��  
        button.setPressedIcon(new ImageIcon("G:/20080906221809543.png")); 
        button.setSelectedIcon(new ImageIcon("G:/4kongcom-0005.png")); 
        button.setText("ssss");
 
        JFrame frame = new JFrame("����:Creat ImagePanel"); 
        frame.getContentPane().add(panel); 
        frame.pack(); 
        frame.setVisible(true); 
    } 
} 