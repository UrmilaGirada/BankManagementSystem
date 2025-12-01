import java.util.ArrayList;

public class BankAccount {
    String name;
    String accountNumber;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactions.add("Account created with balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
        System.out.println("Amount Deposited Successfully!");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            transactions.add("Failed Withdrawal: " + amount + " | Balance: " + balance);
        } else {
            balance -= amount;
            transactions.add("Withdrawn: " + amount + " | Balance: " + balance);
            System.out.println("Withdrawal Successful!");
        }
    }

    void displayDetails() {
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Name       : " + name);
        System.out.println("Account No.: " + accountNumber);
        System.out.println("Balance    : ₹" + balance);
    }

    void printTransactions() {
        System.out.println("\n--- TRANSACTION HISTORY ---");
        for (String t : transactions) System.out.println(t);
    }
}
