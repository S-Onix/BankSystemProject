package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import person.BankCustomer;

public class TestDAO {
	BankDB bankDB;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	public TestDAO() {
		bankDB = BankDB.getInstance();
		conn = null;
		stmt = null;
		rs = null;
		rsmd = null;
	}
	
	public String[][] selectCustomerLog() {
		 String sql = "SELECT * FROM TRANS_LOG WHERE USER_ID = 'test';";


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
