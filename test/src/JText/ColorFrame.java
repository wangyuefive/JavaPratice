package JText;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

public class ColorFrame extends JFrame {
	
	private static final long serialVersionUID = -8985161312279626847L;

	private JPanel panel;
	
	private JTextField redField;
	
	private JTextField greenField;
	
	private JTextField blueField;
	
	public ColorFrame(){
		DocumentListener listener = new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {setColor();}
			public void insertUpdate(DocumentEvent e) {setColor();}
			public void changedUpdate(DocumentEvent e) {}
		};
		
		panel = new JPanel();
		
		panel.add(new JLabel("Red:"));
		redField = new JTextField("255",3);
		panel.add(redField);
		redField.getDocument().addDocumentListener(listener);
		
		panel.add(new JLabel("Green:"));
		greenField = new JTextField("255",3);
		panel.add(greenField);
		greenField.getDocument().addDocumentListener(listener);
		
		panel.add(new JLabel("Blue:"));
		blueField = new JTextField("255",3);
		panel.add(blueField);
		blueField.getDocument().addDocumentListener(listener);
		
		this.add(panel);
		pack();
		
	}
		
	public void setColor()
	{
		try {
			int red = Integer.parseInt(redField.getText().trim());
			int green = Integer.parseInt(greenField.getText().trim());
			int blue = Integer.parseInt(blueField.getText().trim());
			panel.setBackground(new Color(red,green,blue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 程序的入口方法

	public static void main(String[] args) {
		JFrame frame = new ColorFrame();
		frame.setLocation(450, 300);
		// 添加框架窗口的事件监听（监听关闭框架窗口事件）
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 正常推出Java虚拟机
				System.exit(0);
			}
		});
		// 显示框架窗口
		frame.pack();
		frame.setVisible(true);
	}

}
