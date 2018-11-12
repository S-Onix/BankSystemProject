package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BankDB {

	private static BankDB bankDB = new BankDB();
	private static Connection conn = null;
	private static Statement stmt = null;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bank_system";
	private static final String USER = "root";
	private static final String PASSWORD = "oracle";

	private BankDB() {

	}

	public static BankDB getInstance() {
		try {
			System.out.println("Before Driver Loading");
			Class.forName(DRIVER);
			System.out.println("After Driver Loading");
			System.out.println("Before Connection");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("After Connection");
			stmt = conn.createStatement();
			return bankDB;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 수정, 삭제, 입력
	public int setUpdate(String sql) {
		try {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

//	public ArrayList getData(String sql) {
//		ArrayList customers =new ArrayList<>();
//		ResultSet rs;
//		
//		try {
//			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				ResultSetMetaData rsmd = rs.getMetaData();
//				for(int i = 0; i < rsmd.getColumnCount(); i++) {
//					customers.add(rs.getObject(i));
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return customers;
//	}

}
