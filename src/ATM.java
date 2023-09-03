import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Define an Account class to encapsulate account information and operations
class Account {
    private final String accountNumber; // Unique account number
    private final String accountType;   // Type of account (e.g., Checking, Savings)
    private double balance;             // Current account balance

    // Constructor to initialize account details
    public Account(String accountNumber, String accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    // Getters to access account information
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw funds from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false; // Insufficient balance, withdrawal failed
    }

    // Method to transfer funds from this account to another account
    public void transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
        }
    }
}


public class ATM {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        initializeAccounts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.print("Enter your account number (or 'exit' to quit): ");
            String accountNumber = scanner.nextLine();

            if (accountNumber.equalsIgnoreCase("exit")) {
                break;
            }

            Account currentAccount = accounts.get(accountNumber);
            if (currentAccount != null) {
                showAccountMenu(currentAccount);
            } else {
                System.out.println("Invalid account number. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM!");
        scanner.close();
    }

    private static void initializeAccounts() {
        // Initialize sample accounts
        accounts.put("12345", new Account("12345", "Checking", 1000.0));
        accounts.put("67890", new Account("67890", "Savings", 500.0));
    }

    private static void showAccountMenu(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + account.getAccountType() + " Account Holder!");

        while (true) {
            System.out.println("Account Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Your new balance: $" + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your new balance: $" + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance. Please try again.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the recipient's account number: ");
                    String recipientAccountNumber = scanner.next();
                    Account recipientAccount = accounts.get(recipientAccountNumber);
                    if (recipientAccount != null) {
                        System.out.print("Enter the amount to transfer: $");
                        double transferAmount = scanner.nextDouble();
                        account.transfer(recipientAccount, transferAmount);
                        System.out.println("Transfer successful. Your new balance: $" + account.getBalance());
                    } else {
                        System.out.println("Invalid recipient account number. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
