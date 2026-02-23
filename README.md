# Banking System

A simple banking system built in Java that manages different types of accounts (Checking and Savings) using Object-Oriented Programming principles.

## Features

- Create Checking Accounts (with withdrawal fees)
- Create Savings Accounts (with interest rates)
- Deposit money
- Withdraw money (with fee calculation for checking accounts)
- Transfer money between accounts
- Apply interest to savings accounts
- List all accounts
- View total bank balance

## Technologies

- Java 17+
- Object-Oriented Programming (OOP)
- Collections Framework
- Stream API

## Concepts Applied

- **Inheritance**: CheckingAccount and SavingsAccount extend Account
- **Polymorphism**: Different account types handled uniformly
- **Abstract Classes**: Account as base class
- **Encapsulation**: Protected attributes with controlled access
- **Exception Handling**: Input validation and error messages

## Project Structure
```
src/banking/
├── Account.java (abstract)
├── CheckingAccount.java
├── SavingsAccount.java
├── Bank.java
└── Main.java
```

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/ismajoventino/banking-system.git
```

2. Navigate to the project directory:
```bash
cd banking-system
```

3. Compile:
```bash
javac src/banking/*.java
```

4. Run:
```bash
java -cp src banking.Main
```

## Usage Example
```
=== BANKING SYSTEM ===
1. Create Checking Account
2. Create Savings Account
3. Deposit
4. Withdraw
5. Transfer
6. Apply Interest
7. List All Accounts
8. Total Balance
0. Exit

Option: 1
Account Number: 001
Holder: John Doe
Balance: 1000
Withdraw Fee: 2.50
Checking Account created!
```

## What I Learned

- Implementing inheritance and polymorphism in real-world scenarios
- Working with abstract classes and methods
- Using protected attributes for controlled access
- Applying Stream API for searching and filtering
- Exception handling and input validation
- Building interactive CLI applications

