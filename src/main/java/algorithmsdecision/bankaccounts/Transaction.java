package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private TransactionStatus transactionStatus;

    public Transaction(String accountNumber,
                       TransactionOperation transactionOperation,
                       int amount,
                       LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionStatus = transactionStatus;
    }

    public boolean isCredit(){
        return transactionOperation == TransactionOperation.CREDIT;
    }

    public boolean isDebit(){
        return transactionOperation == TransactionOperation.DEBIT;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
