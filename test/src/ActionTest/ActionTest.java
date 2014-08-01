package ActionTest;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

class ActionFrame extends JFrame
{
	public ActionFrame()
	{
		this.setTitle("ActionTest");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		width = (int)(screen.width/2);
		height = (int)(screen.height/2);
		this.setSize(width, height);
		ButtonPanel = new JPanel();
		
		 //监听器 对象 实例
		Action yellowAction = new ColorAction("Yellow Button",Color.YELLOW); 
		Action blueAction =new ColorAction("Blue Button",Color.BLUE);
		Action redAction = new ColorAction("red Button",Color.RED);
		
		//JButton yellowButton = new JButton(yellowAction);
		//JButton blueButton = new JButton(blueAction);
		//JButton redButton = new JButton(redAction);
		 
		
		//按钮，事件源
		TagButton yellowButton = new TagButton("yellowAction");
		TagButton blueButton = new TagButton("blueAction");
		TagButton redButton = new TagButton("redAction");  
		ImageIcon image = new ImageIcon("about.gif");
		
		yellowButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		yellowButton.setVerticalTextPosition(SwingConstants.CENTER);
		yellowButton.setIcon(image);
	
		//事件源 中添加  监听器对象  ；事件产生的时候，调用监听器对象的方法
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);   
		
		text = new JTextField();
		text.setText("用于测试");
		text.setBorder(BorderFactory.createEtchedBorder());
		
		ButtonPanel.add(yellowButton);
		ButtonPanel.add(blueButton);
		ButtonPanel.add(redButton);
		ButtonPanel.add(text);
		
		this.add(ButtonPanel);
	
		InputMap imap = ButtonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("R"), "panel.red");
		
		ActionMap amap = ButtonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	
	}
	
	
	public class ColorAction extends AbstractAction
	{
		public ColorAction(String name,Color c)
		{
			this.putValue(Action.NAME, name);
			this.putValue(Action.SHORT_DESCRIPTION, "set panel color to "+ name.toLowerCase());
			this.putValue("color", c);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			Color c = (Color)getValue("color");
			ButtonPanel.setBackground(c);
		}
	}
	
	class TagButton extends JButton {

		private static final long serialVersionUID = -7732576684131703557L;
		
		private Border emptyBorder = BorderFactory.createEmptyBorder(1,1, 1, 1); 

		private boolean needRelease = false;
		public void setNeedRelease(boolean needRelease){
			this.needRelease = needRelease;
		}
		
		public TagButton(String name) {
			super(name);
			// UiUtil.setComponentSize(this, 80, 80);
	        this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			this.addMouseListener(act_mouseMove);
			this.setBorder(emptyBorder);		
		}

		private MouseListener act_mouseMove = new MouseListener() {

			public void mouseExited(MouseEvent e) {
				if( TagButton.this.isSelected() ){
					return;
				}
	            TagButton.this.setBorder(emptyBorder);
			}

			public void mouseEntered(MouseEvent e) {
				if( TagButton.this.isSelected() ){
					return;
				}
	            TagButton.this.setBorder(new BevelBorder(BevelBorder.RAISED));
			}
			
			public void mouseReleased(MouseEvent e) { 
				if(needRelease){
					TagButton.this.setBorder(emptyBorder);
					TagButton.this.setSelected(false);
				}
			}

			public void mousePressed(MouseEvent e) { 
				if( TagButton.this.isSelected() ){
					return;
				}
	            TagButton.this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			}

			public void mouseClicked(MouseEvent e) { }
		};
	}

	
	private int width;
	private int height;
	private JPanel ButtonPanel ;
	private JTextField text;
}


public class ActionTest {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ActionFrame frame = new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);	
			}
		});

	}
}

