package banking;

public class CheckingAccount extends Account {
	
	private double withdrawFee;

	public CheckingAccount(String accountNumber, String holder, double balance, double withdrawFee) throws IllegalArgumentException {
		super(accountNumber, holder, balance);
		
		if(withdrawFee <= 0) throw new IllegalArgumentException("Withdraw Fee must be greater than zero.");
	
		this.withdrawFee = withdrawFee;
	}

	@Override
	public void withdraw(double amount) throws IllegalArgumentException {
		//if(!(getBalance() < (amount + withdrawFee)) || amount <= 0) throw new IllegalArgumentException("Insufficient balance.");
		double total = amount + withdrawFee;
		
		if(amount <= 0) throw new IllegalArgumentException("Amount must be greater than zero.");
		
		if(balance < total) throw new IllegalArgumentException("Insufficient balance.");
		
		balance -= total;		
	}

	@Override
	public String getAccountType() {
		return "Checking Account.";
		
	}

}
