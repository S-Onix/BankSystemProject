package system;

import java.util.Scanner;

import person.Customer;

public class BankSystem {
	// has a 관계 : BankSystem 클래스는 Customer 객체를 가질 수 있다.

		public Scanner scan;
		public boolean run;
		private Customer[] customers;
		public int count = 0;

		public BankSystem() {
			scan = new Scanner(System.in);
			run = true;
			customers = new Customer[10];
		}

		// 회원가입
		/**
		 * 회원가입 현재 배열로 만든 상태이며 최대 수용인원은 10명이다.
		 * 
		 * */
		public void signUp() {
			System.out.println("회원가입 화면입니다.");
			if (count < 10) {
				customers[count++] = new Customer();
				inputInfo(customers[count-1]);
			} else {
				System.out.println("더이상 회원가입 할 수 없습니다.");
			}
		}

		
		/**
		 * 사용자의 정보를 입력하는 구간이다 (추후 UI에서 받아온 데이터를 통해 사용자 Customer의 정보 저장예정)
		 * */
		private void inputInfo(Customer customer) {
			System.out.print("ID > ");
			customer.setId(scan.next());
			System.out.print("PASSWORD > ");
			customer.setPw(scan.next());
			System.out.print("이름 > ");
			customer.setName(scan.next());
		}

		/**
		 * 현재 : console에서 출력
		 * 완성예정 : UI에서 출력
		 * 사용자의 정보 출력 
		 * */
		public void viewInfo(Customer customer) {
			System.out.println(customer.getName() + "\t" + customer.getId() + "\t" + customer.getBalance());

		}

		// 고객정보 출력
		/**
		 * 현재 : console 출력
		 * 완성예정 : UI에 정보 입력 및 검사 예정
		 * */
		public void printCustomer() {
			System.out.print("어떤 고객을 찾으시나요(이름을 입력하세요) > ");
			String findCustomer = scan.next();
			System.out.println("-------------------------------------------");
			System.out.println("이름\t아이디\t잔고");
			System.out.println("-------------------------------------------");

			for (int i = 0; i < customers.length; i++) {
				if (customers[i] != null) {
					if (customers[i].getName().equals(findCustomer))
						viewInfo(customers[i]);
				} else if (i == customers.length)
					System.out.println("찾으시는 고객님이 없습니다.");
			}
		}

		public Customer checkCustomer() {
			System.out.print("어떤 고객님의 계좌를 찾으시나요? (이름을 입력해 주세요) > ");
			String findCustomer = scan.next();
			String findId;
			String findPw;
			int count = 0;

			for (int i = 0; i < customers.length; i++) {
				if (customers[i] != null) {
					if (customers[i].getName().equals(findCustomer)) {
						System.out.print("ID를 입력해 주세요 > ");
						findId = scan.next();
						if (customers[i].getId().equals(findId)) {
							System.out.print("Password를 입력해 주세요 > ");
							findPw = scan.next();
							if (customers[i].getPw().equals(findPw))
								return customers[i];
							else {
								System.out.println("Password를 잘못 입력 하셨습니다.");
								if (count != 3) {
									i -= 1;
									count++;
								} else if (count == 3) {
									break;
								}
							}
						} else {
							System.out.println("ID를 잘못 입력 하셨습니다.");
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
			System.out.println("찾으시는 회원이 없습니다.");
			return null;
		}

		// 예금
		public void deposit() {
			int money;
			Customer customer = checkCustomer();
			if (customer != null) {
				System.out.print("입금액 > ");
				money = scan.nextInt();
				customer.setBalance(customer.getBalance() + money);
			}
		}

		// 출금
		public void withdraw() {
			int money;
			Customer customer = checkCustomer();
			if (customer != null) {
				System.out.print("출금액 > ");
				money = scan.nextInt();
				customer.setBalance(customer.getBalance() - money);
			}
		}

		// 잔고
		public void printBalance() {
			Customer customer = checkCustomer();
			System.out.println(customer.getName() + "님의 잔고는 " + customer.getBalance() + "원 입니다.");
		}

		public void execute() {
			int menuNum;

			do {
				System.out.println("------------------------------------------------------");
				System.out.println("1. 회원가입 | 2. 고객정보 출력  |  3. 예금  | 4. 출금 | 5. 잔고 | 6.종료");
				System.out.println("------------------------------------------------------");
				System.out.print("선택 > ");
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
					System.out.println("잘못된 입력입니다.(1~6)");
				}
			} while (run);
		}

		public void setRun(boolean run) {
			this.run = run;
		}

	}
