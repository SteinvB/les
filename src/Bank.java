import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private ArrayList<Transaction> transactionLog = new ArrayList<>();

    public void createAccount(String accountNumber, double balance) {
        for (BankAccount account : this.accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                System.out.println("accountNumber already in use.");
                System.out.println("creation aborted.");
                return;
            }
        }
        BankAccount a = new BankAccount(accountNumber, balance);
        this.accounts.add(a);
    }

    public void getExchanged(String accountNumber, String currency) {
        double balance = -1;
        for (BankAccount account : this.accounts) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                balance = account.getBalance();
            }
        }
        if (balance == -1) {
            System.out.println("invalid account number");
            return;
        }
        double dollarRate = 1.077788;
        double poundRate = 0.870196;
        double rupeeRate = 89.265694;
        switch (currency) {
            case "USD": balance = balance * dollarRate;
            case "GBP": balance = balance * poundRate;
            case "INR": balance = balance * rupeeRate;
        }
        System.out.println("balance: " + balance + " " + currency);
    }

    public void getLog() {
        for (Transaction trans : this.transactionLog) {
            System.out.println(trans);
        }
    }

    public void getAll() {
        for (BankAccount account : this.accounts) {
            System.out.println(account.toString());
        }
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : this.accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        for (BankAccount account : this.accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                account.deposit(amount);
                Transaction trans = new Transaction('d', accountNumber, amount);
                this.transactionLog.add(trans);
                return;
            }
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for (BankAccount account : this.accounts) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                account.withdraw(amount);
                Transaction trans = new Transaction('w', accountNumber, amount);
                this.transactionLog.add(trans);
                return;
            }
        }
    }
    private void privateTransfer(String sourceAccount, String recipientAccount, double amount) {
        if (amount <0) {
            System.out.println("amount can't be negative");
            return;
        }
        boolean sourceCheck = false;
        int sourceIndex = -1;
        boolean recipientCheck = false;
        int recipientIndex = -1;
        for (int i = 0; i < this.accounts.size(); i++) {
            if (Objects.equals(this.accounts.get(i).getAccountNumber(), sourceAccount)) {
                sourceCheck = true;
                sourceIndex = i;
            } else if (Objects.equals(this.accounts.get(i).getAccountNumber(), recipientAccount)) {
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
        if (this.accounts.get(sourceIndex).getBalance() < amount) {
            System.out.println("insufficient funds on source account");
            return;
        }
        this.accounts.get(sourceIndex).withdraw(amount);
        this.accounts.get(recipientIndex).deposit(amount);
    }
    public void transfer(String sourceAccount, String recipientAccount, double amount) {
        privateTransfer(sourceAccount, recipientAccount, amount);
        Transaction trans = new Transaction(sourceAccount, recipientAccount, amount);
        this.transactionLog.add(trans);
    }
    public void transfer(String sourceAccount, String recipientAccount, double amount, String transactionDetails) {
        privateTransfer(sourceAccount, recipientAccount, amount);
        Transaction trans = new Transaction(sourceAccount, recipientAccount, amount, transactionDetails);
        this.transactionLog.add(trans);
    }
}
