package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {
    List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccounts(List<BankAccount> bankAccounts) {
        if (bankAccounts == null) throw new IllegalArgumentException("Bankaccounts list is a must!");
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
//        result.sort(Comparator.comparing( BankAccount::getBalance ));
        result.sort(Comparator.comparing((bankAccount) -> Math.abs(bankAccount.getBalance())));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing((BankAccount bankAccount) -> bankAccount.getBalance()).reversed());
        return result;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(Collator.getInstance(new Locale("hu", "HU"))))
                .thenComparing(BankAccount::getAccountNumber));
        return result;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return result;
    }
}
