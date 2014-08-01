package DrawCircle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

class DrawCircle extends JComponent{
	
	private static final long serialVersionUID = 7373112364460356670L;
	private Color drawcolor;  //fill color
	private double radius;
	public static final Color NOTALARM_COLOR = new Color(150,150,150); 
	public static final Color ALARM_COLOR = new Color(255,0,0);
	public static final double DEFAULT_RADIUS = 8;
	
	public Color getColor(){
		return this.drawcolor;
	}
	
	public double getradius()
	{
		return this.radius;
	}
	
	public void setColor(Color acolor, double aradius){
		this.drawcolor = acolor;
		this.radius = aradius;
		this.repaint();
	}
	
	public DrawCircle()
	{
		this.drawcolor = DrawCircle.NOTALARM_COLOR;
		this.radius = DrawCircle.DEFAULT_RADIUS;
		this.repaint();
	}
	
	public DrawCircle(Color acolor)
	{
		this.drawcolor = acolor;
		this.radius = DrawCircle.DEFAULT_RADIUS;
		this.repaint();
	}
	
	public DrawCircle(Color acolor,double aradius)
	{
		this.drawcolor = acolor;
		this.radius = aradius;
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;		
		Ellipse2D circle = new Ellipse2D.Float();
		double centerx = this.getWidth()/2;
		double centery = this.getHeight()/2;
		circle.setFrameFromCenter(centerx , centery, centerx + radius  ,centery + radius);
		g2.setPaint(drawcolor);
		g2.fill(circle);				
	}
}