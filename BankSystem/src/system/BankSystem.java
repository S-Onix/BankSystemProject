package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import person.BankCustomer;

public class BankSystem {
	// has a 관계 : BankSystem 클래스는 Customer 객체를 가질 수 있다.
	// scanner 부분은 전부 UI에서 데이터를 받아와야 함.

	public Scanner scan;
	public boolean run;
	public ArrayList<BankCustomer> customers;
	public int count = 0;
	private Random random;
	StringBuffer sb;

	private BankCustomer loginCustomer;

	public BankSystem() {
		scan = new Scanner(System.in);
		run = true;
		customers = new ArrayList<>();
	}
	
	
	public ArrayList<BankCustomer> getCustomers() {
		return customers;
	}
	
	public BankCustomer getLoginCustomer() {
		return loginCustomer;
	}



	/**
	 * 사용자의 정보를 입력하는 구간이다 (추후 UI에서 받아온 데이터를 통해 사용자 Customer의 정보 저장예정)
	 */
	private void inputInfo(BankCustomer customer) {
		System.out.print("ID > ");
		customer.setId(scan.next());
		System.out.print("PASSWORD > ");
		customer.setPw(scan.next());
		System.out.print("이름 > ");
		customer.setName(scan.next());
		customer.setAccount(createAccount());
		System.out.println("사용자의 계좌번호는 " + customer.getAccount() + " 입니다.");

	}
	
	public void signUp(String id, String pw, String name, String email, String phoneNumber) {
		BankCustomer customer = new BankCustomer();
		customer.setId(id);
		customer.setPw(pw);
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		customer.setAccount(createAccount());
		customers.add(customer);
	}

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
	


	// 이체
	
	public void bankTransfer() {
		System.out.println("어느 고객에게 이체하실 건가요?");
		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		System.out.println("얼마 이체하실 건가요?");
		int transferMoney = scan.nextInt();

		if (loginCustomer.getBalance() - transferMoney < 0) {
			System.out.println("사용자의 금액보다 더 많은 금액을 이체할 수 없습니다");
		} else {
			customer.setBalance(customer.getBalance() + transferMoney);
			loginCustomer.setBalance(loginCustomer.getBalance() - transferMoney);
		}

		System.out.println("현재 사용자의 잔고는 " + loginCustomer.getBalance() + "원 남았습니다");

	}

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
		System.out.print("어떤 고객을 찾으시나요(이름을 입력하세요) > ");
		String findCustomer = scan.next();
		System.out.println("-------------------------------------------");
		System.out.println("이름\t아이디\t계좌번호\t\t\t잔고");
		System.out.println("-------------------------------------------");

		Iterator i = customers.iterator();
		while (i.hasNext()) {
			BankCustomer customer = (BankCustomer) i.next();
			if (customer.getName().equals(findCustomer)) {
				viewInfo(customer);
			}
		}

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

	// 예금 + 시간정보 저장
	public void deposit() {
		int money;
		System.out.print("ID를 입력하세요 >> ");
		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		if (customer != null) {
			System.out.print("입금액 > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() + money);
		} else {
			System.out.println("해당 고객이 없습니다.");
		}
	}

	// 출금
	public void withdraw() {
		int money;
		System.out.print("ID를 입력하세요 >> ");

		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		if (customer != null) {
			System.out.print("출금액 > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() - money);
		} else {
			System.out.println("해당 고객이 없습니다");
		}
	}

	// 잔고
	public void printBalance() {
		System.out.println(loginCustomer.getName() + "님의 잔고는 " + loginCustomer.getBalance() + "원 입니다.");
	}

	public void execute() {
		int menuNum;

		do {
			System.out.println("------------------------------------------------------");
			System.out.println("1. 회원가입 | 2. 로그인  | 3. 고객정보 출력  |  4. 예금  | 5. 출금 | 6. 잔고  | 7. 이체 | 8. 전고객출력 | 9.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택 > ");
			menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
//				signUp();
				break;
			case 2:
//				login();
				break;
			case 3:
				printCustomer();
				break;
			case 4:
				deposit();
				break;
			case 5:
				withdraw();
				break;
			case 6:
				if (loginCustomer != null) {
					printBalance();
				} else {
					System.out.println("로그인 후 사용 가능합니다.");
				}
				break;
			case 7:
				if (loginCustomer != null) {
					bankTransfer();
				} else {
					System.out.println("로그인 후 사용 가능합니다.");
				}
				break;
			case 8:
				printAllCustomer();
			case 9:
				setRun(false);
				break;
			default:
				System.out.println("잘못된 입력입니다.(1~7)");
			}
		} while (run);

	}

	public void setRun(boolean run) {
		this.run = run;
	}

}
