public class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <0) {
            System.out.println("amount can't be negative");
            return;
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <0) {
            System.out.println("amount can't be negative");
            return;
        }
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("insufficient funds");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
