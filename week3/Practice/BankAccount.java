package week3.Practice;

public class BankAccount {
// TODO: Create static variables:

// - bankName (String) - same for all accounts
private static String bankName;
private static int totalAccounts = 0;   
private static double interestRate; 
// - totalAccounts (int) - count of all accounts created                                            
// - interestRate (double) - same rate for all accounts
// TODO: Create instance variables:
private String accountNumber;
private String accountHolder;   
private double balance;     
// - accountNumber (String) - unique for each account
// - accountHolder (String) - unique for each account
// - balance (double) - unique for each account
// TODO: Create constructor that:
// - Initializes instance variables
// - Increments totalAccounts counter
public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = initialBalance;
    totalAccounts++;
}            
// TODO: Create static methods:
// - setBankName(String name)
// - setInterestRate(double rate)
// - getTotalAccounts() - returns count
// - displayBankInfo() - shows bank name and total accounts
public static void setBankName(String name) {
    bankName = name;
} 
public static void setInterestRate(double rate) {
    interestRate = rate;
}       
public static int getTotalAccounts() {
    return totalAccounts;
}         
// TODO: Create instance methods:
// - deposit(double amount)
// - withdraw(double amount)
// - calculateInterest() - uses static interestRate
// - displayAccountInfo()
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    } else {
        System.out.println("Deposit amount must be positive.");
    }
}
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdrew: " + amount);
    } else {
        System.out.println("Invalid withdrawal amount.");
    }
}
public double calculateInterest() {
    return balance * interestRate / 100;
}
public void displayAccountInfo() {
    System.out.println("Bank Name: " + bankName);
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + accountHolder);
    System.out.println("Balance: " + balance);
    System.out.println("Interest Rate: " + interestRate + "%");
}
public static void main(String[] args) {
// TODO: Set bank name and interest rate using static methods
BankAccount.setBankName("Global Bank");
BankAccount.setInterestRate(3.5);           
// TODO: Create multiple BankAccount objects
BankAccount acc1 = new BankAccount("123456", "Alice", 1000);
BankAccount acc2 = new BankAccount("654321", "Bob", 2000);      

// TODO: Show that static members are shared across all objects

System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());    
// TODO: Show that instance members are unique to each object
acc1.displayAccountInfo();
acc2.displayAccountInfo();  
// TODO: Demonstrate calling static methods with and without objects
acc1.deposit(500);              
acc2.withdraw(300); 
acc1.displayAccountInfo();  
acc2.displayAccountInfo();  
System.out.println("Interest for acc1: " + acc1.calculateInterest());   
System.out.println("Interest for acc2: " + acc2.calculateInterest());
  
System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());    
}
}