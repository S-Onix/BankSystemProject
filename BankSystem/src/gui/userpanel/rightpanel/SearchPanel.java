package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import database.TestDAO;

public class SearchPanel extends JPanel {
	TestDAO tdao;
	private JTable table;

	// public SearchPanel(BankSystem bs) {
	public SearchPanel() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.darkGray);
		tdao = new TestDAO();

		String column[] = { "회원", "종류", "금액", "계좌번호", "이체일" };

		table = new JTable(tdao.selectCustomerLog(), column);
		resizeColumnWidth(table);
		JScrollPane scrollpane = new JScrollPane(table);

		this.add(scrollpane);
	}

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

}
