package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean transaction(long amount) {
        if (super.transaction(amount)) {
            return true;
        }
        long newOoverdraftLimit = overdraftLimit + super.getBalance() - amount - costOfTransaction(amount);

        if (newOoverdraftLimit < 0) {
            return false;
        }
        overdraftLimit = newOoverdraftLimit;
        super.balanceToZero();
        return true;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
