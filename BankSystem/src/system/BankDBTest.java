package system;

import java.util.ArrayList;

import database.CustomerDAO;

public class BankDBTest {
	public static void main(String[] args) {
		CustomerDAO c = new CustomerDAO();
		ArrayList<String> data = c.selectAll();
		
		for(int i = 0 ; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
	}
}
