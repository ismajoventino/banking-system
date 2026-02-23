package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
	
	private List<Account> accounts;
	
	public Bank() {
	    this.accounts = new ArrayList<>();
	}

	public void addAccount(Account account) throws IllegalArgumentException{
		if(account == null) throw new IllegalArgumentException("Account cannot be null.");
		
		boolean exists = accounts.stream()
				.anyMatch(acc -> acc.getAccountNumber().equals(account.getAccountNumber()));
		
		if(exists) throw new IllegalArgumentException("Account already registred.");
		
		accounts.add(account);
		
	}
	
	private Account findAccount(String accountNumber) throws IllegalArgumentException{
		Account account = accounts.stream()
			.filter(acc -> acc.getAccountNumber().equals(accountNumber))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Account not found"));
		
		return account;
	}
	
	public void transfer(String fromAccount, String toAccount, double amount) throws IllegalArgumentException{
		if (fromAccount == null || fromAccount.isBlank()) {
			throw new IllegalArgumentException("Sender cannot be null.");
		}
		
		if (toAccount == null || toAccount.isBlank()) {
			throw new IllegalArgumentException("Recipient cannot be null.");
		}
		
		if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than zero.");
		
		if(fromAccount.equals(toAccount)) {
			throw new IllegalArgumentException("Cannot transfer to the same account.");
		}
		
		Account sender = findAccount(fromAccount);
		
		Account recipient = findAccount(toAccount);
		
		sender.withdraw(amount);
		recipient.deposit(amount);
	}
	
	public List<Account> listAllAccounts() {
		return accounts;
		
	}
	
	public double getTotalBalance() {
		double total = accounts.stream()
				.mapToDouble(acc -> acc.balance)
				.sum();
		
		return total;
	}

}
