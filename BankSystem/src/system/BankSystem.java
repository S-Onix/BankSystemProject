package system;

import java.util.Scanner;

import person.Customer;

public class BankSystem {
	// has a ���� : BankSystem Ŭ������ Customer ��ü�� ���� �� �ִ�.

		public Scanner scan;
		public boolean run;
		private Customer[] customers;
		public int count = 0;

		public BankSystem() {
			scan = new Scanner(System.in);
			run = true;
			customers = new Customer[10];
		}

		// ȸ������
		/**
		 * ȸ������ ���� �迭�� ���� �����̸� �ִ� �����ο��� 10���̴�.
		 * 
		 * */
		public void signUp() {
			System.out.println("ȸ������ ȭ���Դϴ�.");
			if (count < 10) {
				customers[count++] = new Customer();
				inputInfo(customers[count-1]);
			} else {
				System.out.println("���̻� ȸ������ �� �� �����ϴ�.");
			}
		}

		
		/**
		 * ������� ������ �Է��ϴ� �����̴� (���� UI���� �޾ƿ� �����͸� ���� ����� Customer�� ���� ���忹��)
		 * */
		private void inputInfo(Customer customer) {
			System.out.print("ID > ");
			customer.setId(scan.next());
			System.out.print("PASSWORD > ");
			customer.setPw(scan.next());
			System.out.print("�̸� > ");
			customer.setName(scan.next());
		}

		/**
		 * ���� : console���� ���
		 * �ϼ����� : UI���� ���
		 * ������� ���� ��� 
		 * */
		public void viewInfo(Customer customer) {
			System.out.println(customer.getName() + "\t" + customer.getId() + "\t" + customer.getBalance());

		}

		// ������ ���
		/**
		 * ���� : console ���
		 * �ϼ����� : UI�� ���� �Է� �� �˻� ����
		 * */
		public void printCustomer() {
			System.out.print("� ���� ã���ó���(�̸��� �Է��ϼ���) > ");
			String findCustomer = scan.next();
			System.out.println("-------------------------------------------");
			System.out.println("�̸�\t���̵�\t�ܰ�");
			System.out.println("-------------------------------------------");

			for (int i = 0; i < customers.length; i++) {
				if (customers[i] != null) {
					if (customers[i].getName().equals(findCustomer))
						viewInfo(customers[i]);
				} else if (i == customers.length)
					System.out.println("ã���ô� ������ �����ϴ�.");
			}
		}

		public Customer checkCustomer() {
			System.out.print("� ������ ���¸� ã���ó���? (�̸��� �Է��� �ּ���) > ");
			String findCustomer = scan.next();
			String findId;
			String findPw;
			int count = 0;

			for (int i = 0; i < customers.length; i++) {
				if (customers[i] != null) {
					if (customers[i].getName().equals(findCustomer)) {
						System.out.print("ID�� �Է��� �ּ��� > ");
						findId = scan.next();
						if (customers[i].getId().equals(findId)) {
							System.out.print("Password�� �Է��� �ּ��� > ");
							findPw = scan.next();
							if (customers[i].getPw().equals(findPw))
								return customers[i];
							else {
								System.out.println("Password�� �߸� �Է� �ϼ̽��ϴ�.");
								if (count != 3) {
									i -= 1;
									count++;
								} else if (count == 3) {
									break;
								}
							}
						} else {
							System.out.println("ID�� �߸� �Է� �ϼ̽��ϴ�.");
							if (count != 3) {
								i -= 1;
								count++;
							} else if (count == 3) {
								break;
							}
						}
					}
				}
			}
			System.out.println("ã���ô� ȸ���� �����ϴ�.");
			return null;
		}

		// ����
		public void deposit() {
			int money;
			Customer customer = checkCustomer();
			if (customer != null) {
				System.out.print("�Աݾ� > ");
				money = scan.nextInt();
				customer.setBalance(customer.getBalance() + money);
			}
		}

		// ���
		public void withdraw() {
			int money;
			Customer customer = checkCustomer();
			if (customer != null) {
				System.out.print("��ݾ� > ");
				money = scan.nextInt();
				customer.setBalance(customer.getBalance() - money);
			}
		}

		// �ܰ�
		public void printBalance() {
			Customer customer = checkCustomer();
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
					deposit();
					break;
				case 4:
					withdraw();
					break;
				case 5:
					printBalance();
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
