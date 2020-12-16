package iozip.transactions;

import java.time.LocalDateTime;

public class Transaction {
    private final long id;
    private final LocalDateTime time;
    private final String account;
    private final Double amount;

    public Transaction(long id, LocalDateTime time, String account, Double amount) {
        this.id = id;
        this.time = time;
        this.account = account;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getAccount() {
        return account;
    }

    public Double getAmount() {
        return amount;
    }
}
// Transaction immutable osztályt, melyben a
// tranzakció azonosítója (long id), a
// tranzakció pontos időpontja (LocalDateTime time), az érintett
// bankszámla száma (String account) és a
// tranzakció összege (double amount) található.