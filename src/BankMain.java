public class BankMain {
    public static void main(String[] args) {
        Bank testBank = new Bank();
        //prints are for testing purposes
        System.out.println("testing addAccount");
        testBank.createAccount("abc123", 300);
        testBank.createAccount("def456", 420.69);
        testBank.createAccount("ghi789", 1000000000);
        System.out.println("testing addAccount on existing account number");
        testBank.createAccount("ghi789", 1000);
        System.out.println("testing getAll");
        testBank.getAll();
        System.out.println("testing withdraw and deposit");
        testBank.withdraw("abc123", 300);
        testBank.deposit("ghi789", 300);
        System.out.println("testing withdraw on insufficient funds");
        testBank.withdraw("abc123", 300);
        System.out.println("testing transfer");
        testBank.transfer("ghi789", "abc123", 300);
        System.out.println("testing transfer on insufficient funds");
        testBank.transfer("abc123", "ghi789", 9999);
        System.out.println("testing getAccount");
        System.out.println(testBank.getAccount("def456"));
        System.out.println("robbing ghi789 for fun");
        testBank.transfer("ghi789", "def456", testBank.getAccount("ghi789").getBalance());
        testBank.getAll();
    }
}
