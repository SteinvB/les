public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // Nieuwe rekening aanmaken
        bank.createAccount("NL01ABCD1234567890", 1000.0);
        bank.createAccount("NL02EFGH1234567890", 500.0);
        // getAll() testen
        bank.getAll();
        // Geld storten
        bank.deposit("NL01ABCD1234567890", 250);
        // Geld opnemen
        bank.withdraw("NL02EFGH1234567890", 200);
        // Geld overmaken
        bank.transfer("NL01ABCD1234567890", "NL02EFGH1234567890", 2.30);
        // Saldo controleren
        System.out.println(bank.getAccount("NL01ABCD1234567890").getBalance());
        // valuta conversie testen
        bank.getExchanged("NL01ABCD1234567890", "INR");
        // Transactie log testen
        bank.getLog();
    }

}
