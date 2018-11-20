package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import person.BankCustomer;

public class BankDB {

	private static BankDB bankDB = new BankDB();
	private static Connection conn = null;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	// 데이터 삽입 과정에서 한글 인코딩이 안되서 추가함
	private static final String URL = "jdbc:mysql://192.168.0.21:3306/bank_system?useUnicode=true&characterEncoding=utf8&autoReconnect=true&validationQuery=select 1";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private BankDB() {
		try {
			Class.forName(DRIVER);
			System.out.println("connection successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static BankDB getInstance() {
		if (bankDB == null) {
			bankDB = new BankDB();
		}
		return bankDB;
	}

	public static Connection getConnect() {
		conn = null;
		try {
			if (conn == null) {
				System.out.println("Driver connect before");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Driver connect success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void destroy(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void destroy(Statement stmt, Connection conn) {
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
