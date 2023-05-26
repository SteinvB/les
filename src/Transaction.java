public class Transaction {
    final String TYPE;
    final String SOURCEACCOUNTNUMBER;
    final String RECIPIENTACCOUNTNUMBER;
    final double AMOUNT;
    final String TRANSACTIONDETAILS;

    public Transaction(String sourceAccountNumber, String recipientAccountNumber, double amount, String transactionDetails) {
        this.TYPE = "transfer";
        this.SOURCEACCOUNTNUMBER = sourceAccountNumber;
        this.RECIPIENTACCOUNTNUMBER = recipientAccountNumber;
        this.AMOUNT = amount;
        this.TRANSACTIONDETAILS = transactionDetails;
    }

    public Transaction(String sourceAccountNumber, String recipientAccountNumber, double amount) {
        this.TYPE = "transfer";
        this.SOURCEACCOUNTNUMBER = sourceAccountNumber;
        this.RECIPIENTACCOUNTNUMBER = recipientAccountNumber;
        this.AMOUNT = amount;
        this.TRANSACTIONDETAILS = null;
    }

    public Transaction(char type, String account, double amount) {
        String tempType = null;
        String tempSource = null;
        String tempRecipient = null;
        this.AMOUNT = amount;
        this.TRANSACTIONDETAILS = null;
        if (type == 'w') {
            tempType = "withdrawal";
            tempSource = account;
        } else if (type == 'd') {
            tempType = "deposit";
            tempRecipient = account;
        }
        this.TYPE = tempType;
        this.SOURCEACCOUNTNUMBER = tempSource;
        this.RECIPIENTACCOUNTNUMBER = tempRecipient;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + TYPE + '\'' +
                ", sourceAccountNumber='" + SOURCEACCOUNTNUMBER + '\'' +
                ", recipientAccountNumber='" + RECIPIENTACCOUNTNUMBER + '\'' +
                ", amount=" + AMOUNT +
                ", transactionDetails='" + TRANSACTIONDETAILS + '\'' +
                '}';
    }
}
