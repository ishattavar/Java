import java.util.Scanner;

public class BankingApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Banking Application");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        int accountId = bank.createAccount(name, balance);
        System.out.println("Account created successfully. Account ID: " + accountId);
    }

    private static void checkBalance() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        try {
            double balance = bank.checkBalance(accountId);
            System.out.println("Current balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void depositMoney() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        try {
            bank.deposit(accountId, amount);
            System.out.println("Money deposited successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        try {
            if (bank.withdraw(accountId, amount)) {
                System.out.println("Money withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
