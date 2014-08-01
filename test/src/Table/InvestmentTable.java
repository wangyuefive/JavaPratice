package Table;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class InvestmentTable {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new InvestmentTableFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

class InvestmentTableFrame extends JFrame{
	public InvestmentTableFrame()
	{
		this.setTitle("InvestmentTableFrame");
		this.setSize(600, 300);
		
		TableModel model = new InvestmentTableModel(30,5,10);
		JTable table = new JTable(model);
		this.add(new JScrollPane(table));
		table.setRowHeight(table.getRowHeight() + 10);
		TableColumn columnModel = (TableColumn) table.getColumnModel().getColumn(0);
		columnModel.setMinWidth(columnModel.getWidth() + 50);
		columnModel.setMaxWidth(columnModel.getWidth() + 50);
	
		
		
	
	}
}

class InvestmentTableModel extends AbstractTableModel
{
	private int years;
	private int minRate;
	private int maxRate;
	
	public InvestmentTableModel(int y, int r1, int r2)
	{
		this.years = y;
		this.minRate = r1;
		this.maxRate = r2;	
	}

	@Override
	public int getColumnCount() {
		
		return maxRate - minRate +1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return years;
	}

	@Override
	public Object getValueAt(int r, int c) {
		double rate = (c + minRate)/100.0;
		int nperiods = r;
		double futureBalance = 100000.0 *Math.pow(1+rate, nperiods);
		return String.format("%.2f", futureBalance);
	}
	
	public String getColumnName(int c)
	{
		return (c + minRate)+ "%";
	}
	
	public boolean isCellEditable(int r,int c)
	{
		return false;
	}
}
