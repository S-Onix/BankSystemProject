package system;

public class MainTest {
	
	public static void main(String[] args) {
		BankSystem bs = new BankSystem();
		for(int i = 0 ; i < 10; i++) {
			String str = bs.createAccount();
			System.out.println(str);
		}
	}
}
