import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;

    public int createAccount(String name, double initialBalance) {
        Account account = new Account(nextAccountId, name, initialBalance);
        accounts.put(nextAccountId, account);
        return nextAccountId++;
    }

    public double checkBalance(int accountId) {
        Account account = accounts.get(accountId);
        if (account != null) {
            return account.getBalance();
        }
        throw new IllegalArgumentException("Account ID not found.");
    }

    public void deposit(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
        } else {
            throw new IllegalArgumentException("Account ID not found.");
        }
    }

    public boolean withdraw(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            return account.withdraw(amount);
        }
        throw new IllegalArgumentException("Account ID not found.");
    }
}

