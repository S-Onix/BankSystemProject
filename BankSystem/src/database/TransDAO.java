package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
		String sql = "INSERT INTO TRANS_LOG (USER_ID, TRANS_TYPE, TRANS_MONEY, TO_ACCOUNT) VALUES('" 
					+ customer.getId() + "','"
					+ transType +"',"
					+ money + ",'"
					+ account+ "');";
		
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
		String sql = "INSERT INTO TRANS_LOG (USER_ID, TRANS_TYPE, TRANS_MONEY) VALUES('" 
					+ customer.getId() + "','"
					+ transType + "',"
					+ money + ");";
		
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
	
}
