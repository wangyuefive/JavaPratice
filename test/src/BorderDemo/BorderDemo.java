package BorderDemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class BorderDemo extends JFrame {
	private static final long serialVersionUID = 1L;

	public BorderDemo() {
		// ���ÿ�ܴ��ڵı���
		super("ʹ�ñ߿������");
		
		// ����5�������͵ı߿�
		Border blackline, etched, raisedbevel, loweredbevel, empty;
		// ������ɫ����״�߿�
		blackline = BorderFactory.createLineBorder(Color.black);
		
		// ����ʴ�̱߿�
		etched = BorderFactory.createEtchedBorder();
		
		// ����͹���߿�
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		// �������ݱ߿�
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		
		// �����յı߿�
		empty = BorderFactory.createEmptyBorder();
		
		// First pane: simple borders
		JPanel simpleBorders = new JPanel();
		simpleBorders.setLayout(new BoxLayout(simpleBorders, BoxLayout.Y_AXIS));

		addCompForBorder(blackline, "��״�߿�", simpleBorders);
		addCompForBorder(etched, "ʴ�̱߿�", simpleBorders);
		addCompForBorder(raisedbevel, "͹���߿�", simpleBorders);
		addCompForBorder(loweredbevel, "���ݱ߿�", simpleBorders);
		addCompForBorder(empty, "�յı߿�", simpleBorders);

		
		// Second pane: titled borders
		JPanel titledBorders = new JPanel();
		titledBorders.setLayout(new BoxLayout(titledBorders, BoxLayout.Y_AXIS));
		TitledBorder titled;

		titled = BorderFactory.createTitledBorder("123");
		addCompForBorder(titled, "default titled border"
				+ " (default just., default pos.)", titledBorders);

		titled = BorderFactory.createTitledBorder(blackline, "title");
		addCompForTitledBorder(titled, "titled line border"
				+ " (centered, default pos.)", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION, titledBorders);

		titled = BorderFactory.createTitledBorder(etched, "title");
		addCompForTitledBorder(titled, "titled etched border"
				+ " (right just., default pos.)", TitledBorder.RIGHT,
				TitledBorder.DEFAULT_POSITION, titledBorders);

		titled = BorderFactory.createTitledBorder(loweredbevel, "title");
		addCompForTitledBorder(titled, "titled lowered bevel border"
				+ " (default just., above top)",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP,
				titledBorders);

		titled = BorderFactory.createTitledBorder(empty, "title");
		addCompForTitledBorder(titled, "titled empty border"
				+ " (default just., bottom)",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BOTTOM,
				titledBorders);

		// ����TabbledPane���
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("�򵥵ı߿�", null, simpleBorders, null);

		tabbedPane.addTab("���б���ı߿�", null, titledBorders, null);

		tabbedPane.setSelectedIndex(0);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	// ��Ӵ��б���ı߿�
	void addCompForTitledBorder(TitledBorder border, String description,int justification, 
			int position, Container container) {
		border.setTitleJustification(justification);
		border.setTitlePosition(position);
		addCompForBorder(border, description, container);
	}

	// ��Ӽ򵥵ı߿�
	void addCompForBorder(Border border, String description, Container container) {
		JPanel comp = new JPanel(false);
		JLabel label = new JLabel(description, JLabel.CENTER);
		comp.setLayout(new GridLayout(1, 1));
		comp.add(label);
		comp.setBorder(border);

		container.add(Box.createRigidArea(new Dimension(0, 10)));//���ü��
		container.add(comp);
	}

	// �������ڷ���
	public static void main(String[] args) {
		JFrame frame = new BorderDemo();
		frame.setLocation(450, 300);
		// ��ӿ�ܴ��ڵ��¼������������رտ�ܴ����¼���
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// �����Ƴ�Java�����
				System.exit(0);
			}
		});
		// ��ʾ��ܴ���
		frame.pack();
		frame.setVisible(true);
		
	}
}

