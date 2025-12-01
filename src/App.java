import java.util.*;

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = FileManager.load();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. View Transaction History");
            System.out.println("7. Save & Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> viewDetails();
                case 6 -> viewTransactions();
                case 7 -> {
                    FileManager.save(accounts);
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    static void createAccount() {
        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(name, accNo, balance));
        System.out.println("Account Created Successfully!");
    }

    static BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber.equals(accNo)) return acc;
        }
        return null;
    }

    static void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);
        if (acc == null) { System.out.println("Account not found!"); return; }

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();
        acc.deposit(amt);
    }

    static void withdraw() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);
        if (acc == null) { System.out.println("Account not found!"); return; }

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();
        acc.withdraw(amt);
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);
        if (acc == null) { System.out.println("Account not found!"); return; }

        System.out.println("Current Balance: ₹" + acc.balance);
    }

    static void viewDetails() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);
        if (acc == null) { System.out.println("Account not found!"); return; }

        acc.displayDetails();
    }

    static void viewTransactions() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);
        if (acc == null) { System.out.println("Account not found!"); return; }

        acc.printTransactions();
    }
}
