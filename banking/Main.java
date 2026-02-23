package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        
        int option = 0;
        
        do {
            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Apply Interest");
            System.out.println("7. List All Accounts");
            System.out.println("8. Total Balance");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            
            try {
                option = scan.nextInt();
                scan.nextLine();
                
                switch (option) {
                    
                    case 0 -> {
                        System.out.println("Goodbye!");
                    }
                    
                    case 1 -> {
                        System.out.print("Account Number: ");
                        String accNum = scan.nextLine();
                        
                        System.out.print("Holder: ");
                        String holder = scan.nextLine();
                        
                        System.out.print("Balance: ");
                        double balance = scan.nextDouble();
                        scan.nextLine();
                        
                        System.out.print("Withdraw Fee: ");
                        double fee = scan.nextDouble();
                        scan.nextLine();
                        
                        CheckingAccount acc = new CheckingAccount(accNum, holder, balance, fee);
                        bank.addAccount(acc);
                        
                        System.out.println("Checking Account created!");
                    }
                    
                    case 2 -> {
                        System.out.print("Account Number: ");
                        String accNum = scan.nextLine();
                        
                        System.out.print("Holder: ");
                        String holder = scan.nextLine();
                        
                        System.out.print("Balance: ");
                        double balance = scan.nextDouble();
                        scan.nextLine();
                        
                        System.out.print("Interest Rate: ");
                        double rate = scan.nextDouble();
                        scan.nextLine();
                        
                        SavingsAccount acc = new SavingsAccount(accNum, holder, balance, rate);
                        bank.addAccount(acc);
                        
                        System.out.println("Savings Account created!");
                    }
                    
                    case 3 -> {
                        System.out.print("Account Number: ");
                        String accNum = scan.nextLine();
                        
                        System.out.print("Amount: ");
                        double amount = scan.nextDouble();
                        scan.nextLine();
                        
               
                        Account acc = bank.listAllAccounts().stream()
                            .filter(a -> a.getAccountNumber().equals(accNum))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Account not found"));
                        
                        acc.deposit(amount);
                        System.out.println("Deposit successful!");
                    }
                    
                    case 4 -> {
                        System.out.print("Account Number: ");
                        String accNum = scan.nextLine();
                        
                        System.out.print("Amount: ");
                        double amount = scan.nextDouble();
                        scan.nextLine();
                        
                        Account acc = bank.listAllAccounts().stream()
                            .filter(a -> a.getAccountNumber().equals(accNum))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Account not found"));
                        
                        acc.withdraw(amount);
                        System.out.println("Withdraw successful!");
                    }
                    
                    case 5 -> {
                        System.out.print("From Account: ");
                        String from = scan.nextLine();
                        
                        System.out.print("To Account: ");
                        String to = scan.nextLine();
                        
                        System.out.print("Amount: ");
                        double amount = scan.nextDouble();
                        scan.nextLine();
                        
                        bank.transfer(from, to, amount);
                        System.out.println("Transfer successful!");
                    }
                    
                    case 6 -> {
                        System.out.print("Account Number: ");
                        String accNum = scan.nextLine();
                        
                        Account acc = bank.listAllAccounts().stream()
                            .filter(a -> a.getAccountNumber().equals(accNum))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Account not found"));
                        
                        if (acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).applyInterest();
                            System.out.println("Interest applied!");
                        } else {
                            System.out.println("Not a Savings Account!");
                        }
                    }
                    
                    case 7 -> {
                        System.out.println("\n=== ALL ACCOUNTS ===");
                        for (Account acc : bank.listAllAccounts()) {
                            System.out.println(acc.getAccountNumber() + " - " + 
                                             acc.getHolder() + " - " + 
                                             acc.getAccountType() + " - R$ " + 
                                             acc.getBalance());
                        }
                    }
                    
                    case 8 -> {
                        System.out.println("Total Balance: R$ " + bank.getTotalBalance());
                    }
                    
                    default -> {
                        System.out.println("Invalid option!");
                    }
                }
                
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Enter a valid number!");
                scan.nextLine();
                option = -1;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            
        } while (option != 0);
        
        scan.close();
    }
}