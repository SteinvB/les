import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    ArrayList<BankAccount> accounts = new ArrayList<>();
    public void createAccount(String accountNumber, double balance) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                System.out.println("accountNumber already in use.");
                System.out.println("creation aborted.");
                return;
            }
        }
        BankAccount a = new BankAccount(accountNumber, balance);
        accounts.add(a);
    }

    public void getAll() {
        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                account.deposit(amount);
            }
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                account.withdraw(amount);
            }
        }
    }
    public void transfer(String sourceAccount, String recipientAccount, double amount) {
        boolean sourceCheck = false;
        int sourceIndex = -1;
        boolean recipientCheck = false;
        int recipientIndex = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (Objects.equals(accounts.get(i).getAccountNumber(), sourceAccount)) {
                sourceCheck = true;
                sourceIndex = i;
            } else if (Objects.equals(accounts.get(i).getAccountNumber(), recipientAccount)) {
                recipientCheck = true;
                recipientIndex = i;
            }
            if (sourceCheck && recipientCheck) {
                break;
            }
        }
        if (!(sourceCheck && recipientCheck)) {
            System.out.println("invalid account number(s)");
            return;
        }
        if (accounts.get(sourceIndex).getBalance() < amount) {
            System.out.println("insufficient funds on source account");
            return;
        }
        accounts.get(sourceIndex).withdraw(amount);
        accounts.get(recipientIndex).deposit(amount);
    }
}
