package Table;

import java.awt.BorderLayout;  
import java.awt.EventQueue;  
   
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;  
   
public class RendererSample {  
   
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub   
   
        final Object rows[][] = {  
                {"one", "ichi - \u4E00"},  
                {"two", "ni - \u4E8C"},  
                {"three", "san - \u4E09"},  
                {"four", "shi - \u56DB"},  
                {"fiv", "go - \u4E94"},  
                {"six", "roku - \u516D"},  
                {"seven", "shichi - \u4E03"},  
                {"eight", "hachi - \u516B"},  
                {"nine", "kyu - \u4E5D"},  
                {"ten", "ju - \u5341"}  
        };  
   
        final Object headers[] = {"English", "Japanese"};  
   
        Runnable runner = new Runnable() {  
            public void run() {  
                JFrame frame = new JFrame("Renderer Sample");  
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                JTable table = new JTable(rows, headers);  
                TableCellRenderer renderer = new EvenOddRenderer();  
                table.setDefaultRenderer(Object.class, renderer); 
                table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                JScrollPane scrollPane = new JScrollPane(table);  
                frame.add(scrollPane, BorderLayout.CENTER);  
                frame.setSize(300, 150);  
                frame.setVisible(true);  
            }  
        };  
        EventQueue.invokeLater(runner);  
    }  
   
}  