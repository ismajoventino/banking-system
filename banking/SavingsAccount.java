package banking;

public class SavingsAccount extends Account {

	private double interestRate;
	
	public SavingsAccount(String accountNumber, String holder, double balance, double interestRate) throws IllegalArgumentException  {
		super(accountNumber, holder, balance);
		
		if(interestRate <= 0) throw new IllegalArgumentException("Interest rate must be greater than zero.");
		
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		balance += balance * (interestRate / 100);
	}

	@Override
	public void withdraw(double amount) throws IllegalArgumentException{
		if(amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero.");
		}
		
		if(balance < amount) {
			throw new IllegalArgumentException("Insufficient balance.");
		}
		
		balance -= amount;
	}

	@Override
	public String getAccountType() {
		return "Savings Account.";
	}

}
