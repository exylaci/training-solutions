package exceptionclass.bank2;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) throw new IllegalArgumentException();
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100000;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) throw new InvalidAmountBankOperationException("Ha akarom, lehet itt egyedi üzenet");
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) {
        if (amount < 0) throw new InvalidAmountBankOperationException("Ha akarom, lehet itt egyedi üzenet");
        if (amount > balance) throw new LowBalanceBankOperationException("Ha akarom, lehet itt egyedi üzenet");
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) throw new InvalidAmountBankOperationException("Ha akarom, lehet itt egyedi üzenet");
        balance += amount;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}