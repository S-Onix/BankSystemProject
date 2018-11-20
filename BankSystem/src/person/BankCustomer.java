package person;

public class BankCustomer extends BankRelative {

	private String account;
	private int balance;
	private String email;
	private String phoneNumber;
	private String grade;

	public BankCustomer() {
		this.balance = 0;
		this.grade = "normal";
	}

	public BankCustomer(String id, String pw, String name, String email, String phoneNumber, String account, int balance, String grade) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.balance = balance;
		this.grade = grade;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
