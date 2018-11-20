package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {
	BankDB bankDB;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	public CustomerDAO() {
		bankDB = BankDB.getInstance();
		conn = null;
		stmt = null;
		rs = null;
		rsmd = null;
	}

	public ArrayList<String> selectAll() {
		String sql = "SELECT * FROM CUSTOMER";

		ArrayList<String> data = new ArrayList<>();
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
			while (rs.next()) {
				for (int i = 1; i <= columCount; i++) {
					if (i == 7) {
						sb.append(rs.getInt(i) + "|");
					} else if (i == columCount) {
						sb.append(rs.getString(i));
					} else {
						sb.append(rs.getString(i) + "|");
					}
				}
				String result = sb.toString();
				data.add(result);
				sb.delete(0, sb.length());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bankDB.destroy(rs, stmt, conn);
		}

		return data;
	}

	public void insertCustomer(String id, String pw, String name, String email, String phone, String account) {
		String sql = "INSERT INTO CUSTOMER VALUES('" + id + "','" + pw + "','" + name + "','" + email + "','" + phone
				+ "','" + account + "'," + 0 + ",'" + "normal'" + ");";
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

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void deleteCustomer(String id) {
		String sql = "DELETE" + " FROM CUSTOMER" + " WHERE USER_ID = '" + id + "'";
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
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateCustomerDB(String id, int balance) {
		String sql = "UPDATE CUSTOMER" + " SET USER_BALANCE = " + balance + " WHERE USER_ID = '" + id + "';";

		stmt = null;
		conn = null;
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
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
