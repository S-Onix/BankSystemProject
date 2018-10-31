package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import person.BankCustomer;

public class BankSystem {
	// has a ���� : BankSystem Ŭ������ Customer ��ü�� ���� �� �ִ�.
	// scanner �κ��� ���� UI���� �����͸� �޾ƿ;� ��.

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
	 * ������� ������ �Է��ϴ� �����̴� (���� UI���� �޾ƿ� �����͸� ���� ����� Customer�� ���� ���忹��)
	 */
	private void inputInfo(BankCustomer customer) {
		System.out.print("ID > ");
		customer.setId(scan.next());
		System.out.print("PASSWORD > ");
		customer.setPw(scan.next());
		System.out.print("�̸� > ");
		customer.setName(scan.next());
		customer.setAccount(createAccount());
		System.out.println("������� ���¹�ȣ�� " + customer.getAccount() + " �Դϴ�.");

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
	


	// ��ü
	
	public void bankTransfer() {
		System.out.println("��� ������ ��ü�Ͻ� �ǰ���?");
		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		System.out.println("�� ��ü�Ͻ� �ǰ���?");
		int transferMoney = scan.nextInt();

		if (loginCustomer.getBalance() - transferMoney < 0) {
			System.out.println("������� �ݾ׺��� �� ���� �ݾ��� ��ü�� �� �����ϴ�");
		} else {
			customer.setBalance(customer.getBalance() + transferMoney);
			loginCustomer.setBalance(loginCustomer.getBalance() - transferMoney);
		}

		System.out.println("���� ������� �ܰ�� " + loginCustomer.getBalance() + "�� ���ҽ��ϴ�");

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
	 * ���� : console���� ��� �ϼ����� : UI���� ��� ������� ���� ���
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

	// ������ ���
	/**
	 * ���� : console ��� �ϼ����� : UI�� ���� �Է� �� �˻� ����
	 */
	public void printCustomer() {
		System.out.print("� ���� ã���ó���(�̸��� �Է��ϼ���) > ");
		String findCustomer = scan.next();
		System.out.println("-------------------------------------------");
		System.out.println("�̸�\t���̵�\t���¹�ȣ\t\t\t�ܰ�");
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

	// ���� + �ð����� ����
	public void deposit() {
		int money;
		System.out.print("ID�� �Է��ϼ��� >> ");
		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		if (customer != null) {
			System.out.print("�Աݾ� > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() + money);
		} else {
			System.out.println("�ش� ���� �����ϴ�.");
		}
	}

	// ���
	public void withdraw() {
		int money;
		System.out.print("ID�� �Է��ϼ��� >> ");

		String id = scan.next();
		BankCustomer customer = findCustomer(id);
		if (customer != null) {
			System.out.print("��ݾ� > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() - money);
		} else {
			System.out.println("�ش� ���� �����ϴ�");
		}
	}

	// �ܰ�
	public void printBalance() {
		System.out.println(loginCustomer.getName() + "���� �ܰ�� " + loginCustomer.getBalance() + "�� �Դϴ�.");
	}

	public void execute() {
		int menuNum;

		do {
			System.out.println("------------------------------------------------------");
			System.out.println("1. ȸ������ | 2. �α���  | 3. ������ ���  |  4. ����  | 5. ��� | 6. �ܰ�  | 7. ��ü | 8. ������� | 9.����");
			System.out.println("------------------------------------------------------");
			System.out.print("���� > ");
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
					System.out.println("�α��� �� ��� �����մϴ�.");
				}
				break;
			case 7:
				if (loginCustomer != null) {
					bankTransfer();
				} else {
					System.out.println("�α��� �� ��� �����մϴ�.");
				}
				break;
			case 8:
				printAllCustomer();
			case 9:
				setRun(false);
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.(1~7)");
			}
		} while (run);

	}

	public void setRun(boolean run) {
		this.run = run;
	}

}
