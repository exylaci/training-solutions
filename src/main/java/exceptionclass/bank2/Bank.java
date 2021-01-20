package exceptionclass.bank2;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) {
        if (accounts == null) throw new IllegalArgumentException();
        this.accounts = new ArrayList<>(accounts);
    }

    public void payment(String accountNumber, double amount) {
        Account current = findAccount(accountNumber);
        current.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        Account current = findAccount(accountNumber);
        current.deposit(amount);
    }

    private Account findAccount(String accountNumber) {
        if (accountNumber == null) throw new InvalidAccountNumberBankOperationException("Ha akarom, lehet itt egyedi üzenet");
        for (Account one : accounts) {
            if (accountNumber.equals(one.getAccountNumber())) {
                return one;
            }
        }
        throw new InvalidAccountNumberBankOperationException("Ha akarom, lehet itt egyedi üzenet");
    }
}