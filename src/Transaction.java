public class Transaction {
    final String type;
    final String sourceAccountNumber;
    final String recipientAccountNumber;
    final double amount;
    final String transactionDetails;

    public Transaction(String sourceAccountNumber, String recipientAccountNumber, double amount, String transactionDetails) {
        this.type = "transfer";
        this.sourceAccountNumber = sourceAccountNumber;
        this.recipientAccountNumber = recipientAccountNumber;
        this.amount = amount;
        this.transactionDetails = transactionDetails;
    }

    public Transaction(String sourceAccountNumber, String recipientAccountNumber, double amount) {
        this.type = "transfer";
        this.sourceAccountNumber = sourceAccountNumber;
        this.recipientAccountNumber = recipientAccountNumber;
        this.amount = amount;
        this.transactionDetails = null;
    }

    public Transaction(char type, String account, double amount) {
        String tempType = null;
        String tempSource = null;
        String tempRecipient = null;
        this.amount = amount;
        this.transactionDetails = null;
        if (type == 'w') {
            tempType = "withdrawal";
            tempSource = account;
        } else if (type == 'd') {
            tempType = "deposit";
            tempRecipient = account;
        }
        this.type = tempType;
        this.sourceAccountNumber = tempSource;
        this.recipientAccountNumber = tempRecipient;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", sourceAccountNumber='" + sourceAccountNumber + '\'' +
                ", recipientAccountNumber='" + recipientAccountNumber + '\'' +
                ", amount=" + amount +
                ", transactionDetails='" + transactionDetails + '\'' +
                '}';
    }
}
