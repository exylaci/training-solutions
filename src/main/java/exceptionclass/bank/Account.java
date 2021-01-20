package exceptionclass.bank;

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
        if (maxSubtract < 0) throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) {
        if (amount < 0) throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        if (amount > balance) throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
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