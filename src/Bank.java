import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private ArrayList<Transaction> transactionLog = new ArrayList<>();
    private double dollarRate = 1.077788;
    private double poundRate = 0.870196;
    private double rupeeRate = 89.265694;
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

    public void getExchanged(String accountNumber, String currency) {
        double balance = -1;
        for (BankAccount account : accounts) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                balance = account.getBalance();
            }
        }
        if (balance == -1) {
            System.out.println("invalid account number");
            return;
        }
        switch (currency) {
            case "USD": balance = balance * dollarRate;
            case "GBP": balance = balance * poundRate;
            case "INR": balance = balance * rupeeRate;
        }
        System.out.println("balance: " + balance + " " + currency);
    }

    public void getLog() {
        for (Transaction trans : transactionLog) {
            System.out.println(trans);
        }
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
                Transaction trans = new Transaction('d', accountNumber, amount);
                transactionLog.add(trans);
                return;
            }
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                account.withdraw(amount);
                Transaction trans = new Transaction('w', accountNumber, amount);
                transactionLog.add(trans);
                return;
            }
        }
    }
    private void ptransfer(String sourceAccount, String recipientAccount, double amount) {
        if (amount <0) {
            System.out.println("amount can't be negative");
            return;
        }
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
        Transaction temp = new Transaction(sourceAccount, recipientAccount, amount);
    }
    public void transfer(String sourceAccount, String recipientAccount, double amount) {
        ptransfer(sourceAccount, recipientAccount, amount);
        Transaction trans = new Transaction(sourceAccount, recipientAccount, amount);
        transactionLog.add(trans);
    }
    public void transfer(String sourceAccount, String recipientAccount, double amount, String transactionDetails) {
        ptransfer(sourceAccount, recipientAccount, amount);
        Transaction trans = new Transaction(sourceAccount, recipientAccount, amount, transactionDetails);
        transactionLog.add(trans);
    }
}
