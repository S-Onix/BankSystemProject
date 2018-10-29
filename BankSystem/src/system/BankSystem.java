package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import person.Customer;

public class BankSystem {
	// has a ���� : BankSystem Ŭ������ Customer ��ü�� ���� �� �ִ�.

	public Scanner scan;
	public boolean run;
//	private Customer[] customers;
	private ArrayList<Customer> customers;
	public int count = 0;
	private Random random;
	StringBuffer sb;

	public BankSystem() {
		scan = new Scanner(System.in);
		run = true;
		customers = new ArrayList<>();
	}

	// ȸ������
	/**
	 * ȸ������ ���� �迭�� ���� �����̸� �ִ� �����ο��� 10���̴�.
	 * 
	 */
	public void signUp() {
//		System.out.println("ȸ������ ȭ���Դϴ�.");
//		if (count < 10) {
//			customers[count++] = new Customer();
//			inputInfo(customers[count - 1]);
//		} else {
//			System.out.println("���̻� ȸ������ �� �� �����ϴ�.");
//		}
		Customer customer = new Customer();
		inputInfo(customer);
		customers.add(customer);

	}

	/**
	 * ������� ������ �Է��ϴ� �����̴� (���� UI���� �޾ƿ� �����͸� ���� ����� Customer�� ���� ���忹��)
	 */
	private void inputInfo(Customer customer) {
		System.out.print("ID > ");
		customer.setId(scan.next());
		System.out.print("PASSWORD > ");
		customer.setPw(scan.next());
		System.out.print("�̸� > ");
		customer.setName(scan.next());
		customer.setAccount(createAccount());
		System.out.println("������� ���¹�ȣ�� " + customer.getAccount() + " �Դϴ�.");

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
	public void viewInfo(Customer customer) {
		System.out.println(customer.getName() + "\t" + customer.getId() + "\t" + customer.getBalance());

	}

	// ������ ���
	/**
	 * ���� : console ��� �ϼ����� : UI�� ���� �Է� �� �˻� ����
	 */
	public void printCustomer() {
		System.out.print("� ���� ã���ó���(�̸��� �Է��ϼ���) > ");
		String findCustomer = scan.next();
		System.out.println("-------------------------------------------");
		System.out.println("�̸�\t���̵�\t�ܰ�");
		System.out.println("-------------------------------------------");

		Iterator i = customers.iterator();
		while (i.hasNext()) {
			Customer customer = (Customer) i.next();
			if (customer.getName().equals(findCustomer)) {
				viewInfo(customer);
			}
		}

//		for (int i = 0; i < customers.length; i++) {
//			if (customers[i] != null) {
//				if (customers[i].getName().equals(findCustomer))
//					viewInfo(customers[i]);
//			} else if (i == customers.length)
//				System.out.println("ã���ô� ������ �����ϴ�.");
//		}
	}

	public Customer checkCustomer(String name, String id, String password) {
		System.out.print("� ������ ���¸� ã���ó���? (�̸��� �Է��� �ּ���) > ");
		// ���� UI�� ����

		int count = 0;

		Iterator i = customers.iterator();
		while (i.hasNext()) {
			Customer customer = (Customer) i.next();
			while (count != 3) {
				if (customer.getName().equals(name) && customer.getId().equals(id)
						&& customer.getPw().equals(password)) {
					// �ùٸ��� ���

					break;
				} else {
					// �߸� �Է��߽��ϴ� �ٽ� �Է����ּ���
					count++;
				}
			}
		}

//		for (int i = 0; i < customers.length; i++) {
//			if (customers[i] != null) {
//				if (customers[i].getName().equals(findCustomer)) {
//					System.out.print("ID�� �Է��� �ּ��� > ");
//					findId = scan.next();
//					if (customers[i].getId().equals(findId)) {
//						System.out.print("Password�� �Է��� �ּ��� > ");
//						findPw = scan.next();
//						if (customers[i].getPw().equals(findPw))
//							return customers[i];
//						else {
//							System.out.println("Password�� �߸� �Է� �ϼ̽��ϴ�.");
//							if (count != 3) {
//								i -= 1;
//								count++;
//							} else if (count == 3) {
//								break;
//							}
//						}
//					} else {
//						System.out.println("ID�� �߸� �Է� �ϼ̽��ϴ�.");
//						if (count != 3) {
//							i -= 1;
//							count++;
//						} else if (count == 3) {
//							break;
//						}
//					}
//				}
//			}
//		}
		System.out.println("ã���ô� ȸ���� �����ϴ�.");
		return null;
	}

	// ����
	public void deposit(String name, String id, String pw) {
		int money;
		Customer customer = checkCustomer(name, id, pw);
		if (customer != null) {
			System.out.print("�Աݾ� > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() + money);
		}
	}

	// ���
	public void withdraw(String name, String id, String pw) {
		int money;
		Customer customer = checkCustomer(name, id, pw);
		if (customer != null) {
			System.out.print("��ݾ� > ");
			money = scan.nextInt();
			customer.setBalance(customer.getBalance() - money);
		}
	}

	// �ܰ�
	public void printBalance(String name, String id, String pw) {
		Customer customer = checkCustomer(name, id, pw);
		System.out.println(customer.getName() + "���� �ܰ�� " + customer.getBalance() + "�� �Դϴ�.");
	}

	public void execute() {
		int menuNum;

		do {
			System.out.println("------------------------------------------------------");
			System.out.println("1. ȸ������ | 2. ������ ���  |  3. ����  | 4. ��� | 5. �ܰ� | 6.����");
			System.out.println("------------------------------------------------------");
			System.out.print("���� > ");
			menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
				signUp();
				break;
			case 2:
				printCustomer();
				break;
			case 3:
//				deposit();
				break;
			case 4:
//				withdraw();
				break;
			case 5:
//				printBalance();
				break;
			case 6:
				setRun(false);
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.(1~6)");
			}
		} while (run);
	}

	public void setRun(boolean run) {
		this.run = run;
	}

}
