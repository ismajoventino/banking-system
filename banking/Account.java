package banking;

public abstract class Account {
	
	private String accountNumber;
	private String holder;
	protected double balance;
	
	public Account(String accountNumber, String holder, double balance) throws IllegalArgumentException {
		if(accountNumber == null || accountNumber.isBlank()) throw new IllegalArgumentException("Account number cannot be empty/null.");
		
		if(holder == null || holder.isBlank()) throw new IllegalArgumentException("Holder cannot be empty/null.");
		
		if(balance < 0) throw new IllegalArgumentException("Balance must be greater than zero.");
		
		this.accountNumber = accountNumber;
		this.holder = holder;
		this.balance = balance;
	}

	public void deposit(double amount) throws IllegalArgumentException {
		if(balance <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero.");
		}
		
		balance += amount;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getHolder() {
		return holder;
	}

	public abstract void withdraw(double amount);
	
	public abstract String getAccountType();

	@Override
	public String toString() {
		return "Account: " + accountNumber + ", Holder" + holder + ", Balance: " + balance;
	}
	
}
