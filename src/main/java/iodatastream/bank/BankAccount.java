package iodatastream.bank;

public class BankAccount {
    private String number;
    private String name;
    private double balance;

    public BankAccount(String number, String name, double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return number;
    }

    public String getOwner() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
