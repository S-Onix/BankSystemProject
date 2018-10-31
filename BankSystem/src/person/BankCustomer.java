package person;

public class BankCustomer extends BankRelative{

	private String account;
	private int balance;
	private String email;
	private String phoneNumber;
	private boolean vip;
	
	
	public BankCustomer() {
		this.balance = 0;
		this.vip = false;
	}

	public String getAccount() {
		return account;
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

	public void setAccount(String account) {
		this.account = account;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	

}
