package Jtable;

import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.table.*;  
  
/** 
* @version 1.0 11/09/98 
*/  
public class JButtonTableExample extends JFrame {  
  public JButtonTableExample(){  
    super( "JButtonTable Example" );  
    
    String[] head = {"Button","String"};
    DefaultTableModel dm = new DefaultTableModel(head,4);  
                       
    JTable table = new JTable(dm);  
    table.getColumn("Button").setCellRenderer(new ButtonRenderer());  
    table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));  
    JScrollPane scroll = new JScrollPane(table);  
    getContentPane().add( scroll );  
    setSize( 400, 100 );  
    setVisible(true);  
  }  
  public static void main(String[] args) {  
    JButtonTableExample frame = new JButtonTableExample();  
    frame.addWindowListener(new WindowAdapter() {  
      public void windowClosing(WindowEvent e) {  
        System.exit(0);  
      }  
    });  
  }  
}  
  
