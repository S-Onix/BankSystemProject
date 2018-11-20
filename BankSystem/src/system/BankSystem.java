package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

import database.CustomerDAO;
import database.TransDAO;
import person.BankCustomer;

public class BankSystem implements Bank {
	// has a 관계 : BankSystem 클래스는 Customer 객체를 가질 수 있다.
	// scanner 부분은 전부 UI에서 데이터를 받아와야 함.

	public ArrayList<BankCustomer> customers;
	public int count = 0;
	private Random random;
	StringBuffer sb;
	CustomerDAO cdao;
	TransDAO tdao;

	private BankCustomer loginCustomer;

	public BankSystem() {
		customers = new ArrayList<>();
		cdao = new CustomerDAO();
		tdao = new TransDAO();
		initCustomers();
	}

	/*
	 * DB로 부터 데이터를 가져와 사용자 객체 초기화
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
	 * 사용자 잔고 업데이트
	 */
	public void updateCustomer() {
		cdao.updateCustomerDB(loginCustomer.getId(), loginCustomer.getBalance());
	}

	/*
	 * 회원가입 (ArrayList 객체 추가 + Customer DB에 데이터 추가)
	 */
	public void signUp(String id, String pw, String name, String email, String phoneNumber) {
		BankCustomer customer = new BankCustomer(id, pw, name, email, phoneNumber, createAccount(), 0, "normal");
		customers.add(customer);
		// TODO : file update
		cdao.insertCustomer(id, pw, name, email, phoneNumber, customer.getAccount());
	}

	/*
	 * 저장된 객체와의 비교 후 로그인 가능 여부 판단
	 */
	public boolean login(String id, String pw) {
		String msg = "등록된 고객이 없습니다.";
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
	 * 아이디 중복 여부 검사
	 */
	public boolean isIdDistinct(String id) {
		// 쿼리문을 통해 정상적으로 실행이 된다면 중복 아니면 중복이 아님을 추가하고 싶음
		Iterator<BankCustomer> i = customers.iterator();
		while (i.hasNext()) {
			if (i.next().getId().equals(id))
				return true;
		}
		return false;
	}

	/**
	 * 로그인 사용자 동작
	 */
	public BankCustomer getLoginCustomer() {
		return loginCustomer;
	}

	@Override
	public void deposit(int money) {
		loginCustomer.setBalance(loginCustomer.getBalance() + money);
	}

	@Override
	// TODO : UI에서 제어
	public void withdraw(int money) {
		loginCustomer.setBalance(loginCustomer.getBalance() - money);
	}

	public int getCustomerBalance() {
		return loginCustomer.getBalance();
	}

	/**
	 * 메니저 관련 동작
	 */
	public ArrayList<BankCustomer> getCustomers() {
		return customers;
	}

	/*
	 * 이체기능 : id를 통해 전달
	 */
	public void transMoney(String id, int money) {
		if (loginCustomer.getBalance() - money < 0) {
			return;
		} else {
			loginCustomer.setBalance(loginCustomer.getBalance() - money);
			BankCustomer destCustomer = findCustomer(id);
			destCustomer.setBalance(destCustomer.getBalance() + money);
			cdao.updateCustomerDB(loginCustomer.getId(), loginCustomer.getBalance());
			cdao.updateCustomerDB(destCustomer.getId(), destCustomer.getBalance());
		}

	}

	/*
	 * 계좌 생성
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

	/**
	 * 현재 : console에서 출력 완성예정 : UI에서 출력 사용자의 정보 출력
	 */
	public void viewInfo(BankCustomer customer) {
		System.out.println(customer.getName() + "\t" + customer.getId() + "\t" + customer.getAccount() + "\t\t"
				+ customer.getBalance());

	}

	public void printAllCustomer() {
		Iterator<BankCustomer> i = customers.iterator();
		while (i.hasNext()) {
			viewInfo(i.next());
		}
	}

	// 고객정보 출력
	/**
	 * 현재 : console 출력 완성예정 : UI에 정보 입력 및 검사 예정
	 */
	public void printCustomer() {

	}

	public BankCustomer findCustomer(String id) {

		BankCustomer customer = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(id)) {
				customer = customers.get(i);
				break;
			}
		}
		return customer;
	}

	// 현재 시간 정보 String으로 출력 고객화면에서 사용 예정
	public String getCurrentDate() {
		String date = "";
		return date;
	}
}