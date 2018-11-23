package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

import database.CustomerDAO;
import database.TransDAO;
import person.BankCustomer;

public class BankSystem implements Bank {
	// has a ���� : BankSystem Ŭ������ Customer ��ü�� ���� �� �ִ�.
	// scanner �κ��� ���� UI���� �����͸� �޾ƿ;� ��.

	public ArrayList<BankCustomer> customers;
	public int count = 0;
	private Random random;
	StringBuffer sb;
	CustomerDAO cdao;
	TransDAO tdao;

	String transType[] = { "�Ա�", "���", "������ü" };

	private BankCustomer loginCustomer;

	public BankSystem() {
		customers = new ArrayList<>();
		cdao = new CustomerDAO();
		tdao = new TransDAO();
		initCustomers();
	}

	/*
	 * DB�� ���� �����͸� ������ ����� ��ü �ʱ�ȭ
	 */
	public void initCustomers() {
		ArrayList<String> data = cdao.selectAll();
		Iterator<String> i = data.iterator();
		while (i.hasNext()) {
			String customerStr = i.next();
			StringTokenizer st = new StringTokenizer(customerStr, "|");
			while (st.hasMoreTokens()) {
				BankCustomer customer = new BankCustomer(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken());
				customers.add(customer);
			}
		}
	}

	/*
	 * ����� �ܰ� ������Ʈ
	 */
	public void updateCustomer() {
		cdao.updateCustomerDB(loginCustomer.getId(), loginCustomer.getBalance());
	}

	public boolean isUpdate(int money) {
		if (loginCustomer.getBalance() - money < 0)
			return false;
		else
			return true;
	}

	/*
	 * �ŷ� �̷� ������Ʈ
	 */
	public void updateTransLog(int money, int flag) {
		tdao.insertTransLog(loginCustomer, transType[flag], money);
	}

	public void updateTransLog(int money, int flag, String account) {
		tdao.insertTransLog(loginCustomer, transType[flag], money, account);
	}

	public String[][] getUserTransLog() {
		return tdao.selectCustomerLog(loginCustomer);
	}

	/*
	 * ȸ������ (ArrayList ��ü �߰� + Customer DB�� ������ �߰�)
	 */
	public void signUp(String id, String pw, String name, String email, String phoneNumber) {
		BankCustomer customer = new BankCustomer(id, pw, name, email, phoneNumber, createAccount(), 0, "normal");
		customers.add(customer);
		// TODO : file update
		cdao.insertCustomer(id, pw, name, email, phoneNumber, customer.getAccount());
	}

	/*
	 * ����� ��ü���� �� �� �α��� ���� ���� �Ǵ�
	 */
	public boolean login(String id, String pw) {
		String msg = "��ϵ� ���� �����ϴ�.";
		Iterator<BankCustomer> i = customers.iterator();
		while (i.hasNext()) {
			BankCustomer temp = i.next();
			if (temp.getId().equals(id) && temp.getPw().equals(pw)) {
				loginCustomer = temp;
				return true;
			}
		}
		return false;
	}

	/*
	 * ���̵� �ߺ� ���� �˻�
	 */
	public boolean isIdDistinct(String id) {
		// �������� ���� ���������� ������ �ȴٸ� �ߺ� �ƴϸ� �ߺ��� �ƴ��� �߰��ϰ� ����
		Iterator<BankCustomer> i = customers.iterator();
		while (i.hasNext()) {
			if (i.next().getId().equals(id))
				return true;
		}
		return false;
	}

	/**
	 * �α��� ����� ����
	 */
	public BankCustomer getLoginCustomer() {
		return loginCustomer;
	}

	@Override
	public void deposit(int money) {
		loginCustomer.setBalance(loginCustomer.getBalance() + money);
	}

	@Override
	// TODO : UI���� ����
	public void withdraw(int money) {
		loginCustomer.setBalance(loginCustomer.getBalance() - money);
	}

	public int getCustomerBalance() {
		return loginCustomer.getBalance();
	}

	/**
	 * �޴��� ���� ����
	 */
	public ArrayList<BankCustomer> getCustomers() {
		return customers;
	}

	/*
	 * ��ü��� : account�� ���� ����
	 */
	public boolean transMoney(String account, int money) {
		if (loginCustomer.getBalance() - money < 0) {
			return false;
		} else {
			loginCustomer.setBalance(loginCustomer.getBalance() - money);
			BankCustomer destCustomer = findCustomerByAccount(account);
			if (destCustomer != null) {
				destCustomer.setBalance(destCustomer.getBalance() + money);
				cdao.updateCustomerDB(loginCustomer.getId(), loginCustomer.getBalance());
				cdao.updateCustomerDB(destCustomer.getId(), destCustomer.getBalance());
				return true;
			}
		}
		return false;

	}

	/*
	 * ���� ����
	 */
	public String createAccount() {

		int count = 0;
		String result;
		String first = "";
		random = new Random();

		int firstInt = random.nextInt(999) + 1;
		int temp = firstInt;

		while (temp > 0) {
			count++;
			temp = temp / 10;
		}

		switch (count) {
		case 1:
			first = "00" + firstInt;
			break;
		case 2:
			first = "0" + firstInt;
			break;
		case 3:
			first = "" + firstInt;
			break;
		}

		count = 0;

		String second = "";
		int secondInt = random.nextInt(99999) + 1;
		temp = secondInt;

		while (temp > 0) {
			count++;
			temp = temp / 10;
		}

		switch (count) {
		case 1:
			second = "0000" + secondInt;
			break;
		case 2:
			second = "000" + secondInt;
			break;
		case 3:
			second = "00" + secondInt;
			break;
		case 4:
			second = "0" + secondInt;
			break;
		case 5:
			second = "" + secondInt;
			break;

		}

		count = 0;

		String third = "";
		int thirdInt = random.nextInt(99999) + 1;
		temp = thirdInt;

		while (temp > 0) {
			count++;
			temp = temp / 10;
		}

		switch (count) {
		case 1:
			third = "0000" + thirdInt;
			break;
		case 2:
			third = "000" + thirdInt;
			break;
		case 3:
			third = "00" + thirdInt;
			break;
		case 4:
			third = "0" + thirdInt;
			break;
		case 5:
			third = "" + thirdInt;
			break;

		}

		result = first + "-" + second + "-" + third;

		return result;
	}

	public BankCustomer findCustomerById(String id) {
		BankCustomer customer = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(id)) {
				customer = customers.get(i);
				break;
			}
		}
		return customer;
	}

	public BankCustomer findCustomerByAccount(String account) {

		BankCustomer customer = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getAccount().equals(account)) {
				customer = customers.get(i);
				break;
			}
		}
		return customer;
	}

	// ���� �ð� ���� String���� ��� ��ȭ�鿡�� ��� ����
	public String getCurrentDate() {
		String date = "";
		return date;
	}
}