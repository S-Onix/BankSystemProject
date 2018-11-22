package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import system.BankSystem;

public class SearchPanel extends JPanel implements ActionListener{
	BankSystem bs;
	JButton searchButton;
	private DefaultTableModel model;
	private JTable table;
	String column[] = { "회원", "종류", "금액", "계좌번호", "이체일" };
	JScrollPane scrollpane;

	public SearchPanel(BankSystem bs) {
		this.setBackground(Color.darkGray);
		this.bs = bs;

		
		setLayout(null);

		table = new JTable(bs.getUserTransLog(), column);
		resizeColumnWidth(table);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(187, 41, 452, 428);

		this.add(scrollpane);

		JLabel label = new JLabel("사용자 거래내역");
		label.setForeground(Color.BLACK);
		label.setBounds(187, 16, 101, 15);
		add(label);

		searchButton = new JButton("이력 조회");
		searchButton.setName("CHECK");
		searchButton.setBounds(197, 479, 97, 23);
		add(searchButton);
		
		searchButton.addActionListener(this);
	}

	//글자 크기 조정
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton)e.getSource();
		if(temp.getName().equals("CHECK")) {
			table = null;
			table = new JTable(bs.getUserTransLog(), column);
			resizeColumnWidth(table);
			scrollpane = null;
			scrollpane = new JScrollPane(table);
			scrollpane.setBounds(187, 41, 452, 428);
			this.add(scrollpane);
		}
		
	}
}
