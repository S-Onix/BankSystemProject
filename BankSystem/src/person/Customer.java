package person;

public class Customer extends BankRelative{

	private String account;
	private int balance;
	private boolean vip;
	
	public Customer() {
		this.balance = 0;
		this.vip = false;
	}

	public String getAccount() {
		return account;
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
