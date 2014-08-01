package Table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableSelectionTest {
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new TableSelectionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}	
}

class TableSelectionFrame extends JFrame
{
	private static final long serialVersionUID = -1462612522102344247L;
	public TableSelectionFrame()
	{
		this.setTitle("TableSelectionTest");
		this.setSize(500, 500);
		
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
	
		model = new DefaultTableModel(10, 10);
		for(int i =0;i < model.getRowCount() ; i++)
			for(int j = 0 ; j < model.getColumnCount() ; j++)
				{
					model.setValueAt(100-(i+1)*(j+1), i, j);
				}
			
		table = new JTable(model);
		table.setDefaultRenderer(Object.class, render);
		table.setIntercellSpacing(new Dimension(5,5));
		table.setRowHeight(25);
		table.getColumnModel().removeColumn(table.getColumn("A"));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//model.setRowCount(1);
				System.out.print(model.getValueAt(0, 0)+"====\n" + table.getRowHeight());
			}
		});
		//table.setShowGrid(false);
		table.getTableHeader().setBackground(Color.PINK);
		this.add(new JScrollPane(table),"Center");
		
		removedColumns = new ArrayList<TableColumn>();
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu selectionMenu = new JMenu("selection");
		menuBar.add(selectionMenu);
		
		final JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("Rows");
		final JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("Columns");
		final JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("Cells");
		
		rowsItem.setSelected(table.getRowSelectionAllowed());
		columnsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());
		
		rowsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setRowSelectionAllowed(rowsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		
		selectionMenu.add(rowsItem);
		
		columnsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setColumnSelectionAllowed(columnsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());	
			}
		});
		selectionMenu.add(columnsItem);
		
		cellsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setCellSelectionEnabled(cellsItem.isSelected());
				rowsItem.setSelected(table.getRowSelectionAllowed());
				columnsItem.setSelected(table.getColumnSelectionAllowed());
			}
		});
		selectionMenu.add(cellsItem);	
	}
	
	private DefaultTableModel model;
	private JTable table ;
	private ArrayList<TableColumn> removedColumns;
}
