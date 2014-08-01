package Jtable;

//File: ButtonEditor.java   
/* (swing1.1beta3) */  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.table.*;  
/** 
* @version 1.0 11/09/98 
*/  
public class ButtonEditor extends DefaultCellEditor {  
  protected JButton button;  
  private String    label;  
  private boolean   isPushed;  
  public ButtonEditor(JCheckBox checkBox) {  
    super(checkBox);  
    button = new JButton();  
    button.setOpaque(true);  
    button.addActionListener(new ActionListener() {  
      public void actionPerformed(ActionEvent e) {  
        fireEditingStopped();  
      }  
    });  
  }  
  public Component getTableCellEditorComponent(JTable table, Object value,  
                   boolean isSelected, int row, int column) {  
    if (isSelected) {  
      button.setForeground(table.getSelectionForeground());  
      button.setBackground(table.getSelectionBackground());  
    } else{  
      button.setForeground(table.getForeground());  
      button.setBackground(table.getBackground());  
    }  
    button.setText( "Button" );  
    isPushed = true;  
    return button;  
  }  
  public Object getCellEditorValue() {  
    if (isPushed)  {  
      //    
      //    
      JOptionPane.showMessageDialog(button ,label + ": Ouch!");  
      // System.out.println(label + ": Ouch!");   
    }  
    isPushed = false;  
    return new String( label ) ;  
  }  
    
  public boolean stopCellEditing() {  
    isPushed = false;  
    return super.stopCellEditing();  
  }  
  protected void fireEditingStopped() {  
    super.fireEditingStopped();  
  }  
} 