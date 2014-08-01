package Table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableCellRenderFrame extends JFrame{
	
	private JTable table = new JTable();
	
	public TableCellRenderFrame()
	{
		this.setSize(500, 500);
		Toolkit.getDefaultToolkit();
		String[] header = {"A","B"};
		DefaultTableModel model = new DefaultTableModel(header,6){
			public Class<?> getColumnClass(int c)
			{
				return table.getValueAt(0, c).getClass();
			}
		};
		table.setModel(model);
		table.setRowHeight(40);
		table.setShowGrid(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.getColumn("B").setCellRenderer(new OperationRenderer());
		table.getColumn("B").setCellEditor(new OperationCellEditor());
		for(int i = 0;i<6 ; i++)
			{
				table.setValueAt(false, i, 0);
				table.setValueAt(null, i, 1);
			}
		
		this.add(table);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				TableCellRenderFrame frame = new TableCellRenderFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);		
			}
		});
	}
	
	class OperationRenderer implements TableCellRenderer
	{
		private  TableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

		private JPanel panel = new JPanel();
		
		private JButton btn_check = new JButton("查看");
		
		private JButton btn_edit = new JButton("编辑");
		
		private JButton btn_delete = new JButton("删除");
		
		public OperationRenderer()
		{
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			//panel.setOpaque(false);
			int width = panel.getX();
			System.out.print("==========="+width+"========\n");
			
			this.setComponentSize(btn_check, 40, 25);
			this.setComponentSize(btn_delete, 40, 25);
			this.setComponentSize(btn_edit, 40, 25);
			btn_check.setMargin(new Insets(0, 0, 0, 0));
			btn_delete.setMargin(new Insets(0, 0, 0, 0));
			btn_edit.setMargin(new Insets(0, 0, 0, 0));
			
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_check);
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_edit);
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_delete);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			  Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		      if(isSelected) {  
		           renderer.setBackground(new Color(206,200,200));
		       }  
	          if(row%2==0) {  
	          	renderer.setBackground(new Color(206, 231, 255));  
	          }  
	          else {  
	          	renderer.setBackground(Color.WHITE);  
	          }   
		      if(column != model.findColumn("B"))
		       return renderer;  
		      else
		      {
		        if(row%2 == 0)
		        	panel.setBackground(new Color(206, 231, 255));
		        else
		        	panel.setBackground(Color.WHITE);
		      }
		      return this.panel;
		}	
		
		private void setComponentSize(JComponent c, int width, int height) {
		        c.setMaximumSize(new Dimension(width, height));
		        c.setMinimumSize(new Dimension(width, height));
		        c.setPreferredSize(new Dimension(width, height));
		        c.setSize(width, height) ;
		    }
	}


	class OperationCellEditor extends DefaultCellEditor implements TableCellEditor
	{

		private static final long serialVersionUID = 8701304325037170931L;

		private JPanel panel = new JPanel();
		
		private JButton btn_check = new JButton("查看");
		
		private JButton btn_edit = new JButton("编辑");
		
		private JButton btn_delete = new JButton("删除");
		
		public OperationCellEditor()
		{
			super(new JTextField()); //DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
		    this.setClickCountToStart(1);  // 设置点击几次激活编辑。
		    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			//panel.setOpaque(false);
			
			this.setComponentSize(btn_check, 40, 25);
			this.setComponentSize(btn_delete, 40, 25);
			this.setComponentSize(btn_edit, 40, 25);
			btn_check.setMargin(new Insets(0, 0, 0, 0));
			btn_delete.setMargin(new Insets(0, 0, 0, 0));
			btn_edit.setMargin(new Insets(0, 0, 0, 0));
			
			btn_check.addActionListener(act_check);
			btn_edit.addActionListener(act_edit);
			btn_delete.addActionListener(act_delete);
			
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_check);
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_edit);
			panel.add(Box.createHorizontalStrut(5));
			panel.add(btn_delete);
		}
		
		private void setComponentSize(JComponent c, int width, int height) {
	        c.setMaximumSize(new Dimension(width, height));
	        c.setMinimumSize(new Dimension(width, height));
	        c.setPreferredSize(new Dimension(width, height));
	        c.setSize(width, height) ;
	    }
		
		@Override
		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
		    {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(column == model.findColumn("B"))
			        {
			        	if(row%2 == 0)
			        		panel.setBackground(new Color(206, 231, 255));
			        	else
			        		panel.setBackground(Color.WHITE);
			        	return this.panel;
			        }
				return null;
		    }	
		
		/**
		 * 查看方案的按钮事件，需要判断表格选中行
		 */
		private ActionListener act_check = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("\n=========check========"+table.getX());
				
			}
		};

		/**
		 * 编辑方案的按钮事件，需要判断表格选中行
		 */
		private ActionListener act_edit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("\n=========edit========\\");
				
			}
		};

		/**
		 * 删除方案的按钮事件，需要判断表格选中行
		 */
		private ActionListener act_delete = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("\n=========delete=======\\");
				
			}
		};
	}

}

