package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import person.BankCustomer;

public class TransDAO {
	BankDB bankDB;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	public TransDAO() {
		bankDB = BankDB.getInstance();
		conn = null;
		stmt = null;
		rs = null;
		rsmd = null;
	}

	public void insertTransLog(BankCustomer customer, String transType, int money, String account) {
		String sql = "INSERT INTO TRANS_LOG (USER_ID, TRANS_TYPE, TRANS_MONEY, TO_ACCOUNT) VALUES('" + customer.getId()
				+ "','" + transType + "'," + money + ",'" + account + "');";

		conn = null;
		stmt = null;
		try {
			conn = bankDB.getConnect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > 0 ? "successful" : "fail";
			System.out.println("Customer database update " + msg);
		} catch (SQLException e) {
			System.out.println("Query is not working");
			e.printStackTrace();
		} finally {

			bankDB.destroy(stmt, conn);

		}
	}

	public void insertTransLog(BankCustomer customer, String transType, int money) {
		String sql = "INSERT INTO TRANS_LOG (USER_ID, TRANS_TYPE, TRANS_MONEY) VALUES('" + customer.getId() + "','"
				+ transType + "'," + money + ");";

		conn = null;
		stmt = null;
		try {
			conn = bankDB.getConnect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > 0 ? "successful" : "fail";
			System.out.println("Customer database update " + msg);
		} catch (SQLException e) {
			System.out.println("Query is not working");
			e.printStackTrace();
		} finally {

			bankDB.destroy(stmt, conn);

		}
	}

	/*
	 * 사용자의 거래내역 저장(JTable에 내용 형식에 맞추기위해 String[][] 타입 사용)
	 */

	public String[][] selectCustomerLog(BankCustomer bc) {
		 String sql = "SELECT * FROM TRANS_LOG WHERE USER_ID = '" + bc.getId() + "' ORDER BY RECORD DESC;";


		String[][] dataGroup = null;
		StringBuilder sb = new StringBuilder();
		conn = null;
		stmt = null;
		rs = null;

		try {
			conn = bankDB.getConnect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columCount = rsmd.getColumnCount();

			//컬럼 갯수 및 레코드의 개수를 구하기 위한 사전 작업
			rs.last();
			int lastRow = rs.getRow();
			rs.beforeFirst();
			dataGroup = new String[lastRow][columCount];
			

			while (rs.next()) {
				for (int i = 1; i <= columCount; i++) {
					String data = rs.getString(i);
					if (data == null) {
						dataGroup[rs.getRow() - 1][i - 1] = null;
					} else {
						dataGroup[rs.getRow() - 1][i - 1] = data;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bankDB.destroy(rs, stmt, conn);
		}

		return dataGroup;
	}

}
