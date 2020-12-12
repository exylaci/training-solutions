package transaction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static final String SEPARATOR = ";";
    public static final String CORRUPT_TRANSACTION_FILE = "Corrupt transaction file!";
    public static final String CORRUPT_BANK_ACCOUNTS_FILE = "Corrupt Bank Accounts file!";
    public static final String CAN_T_READ_FROM_FILE = "Can't read from file!";

    List<BankAccount> accounts = new ArrayList<>();

    public void uploadListFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
            putIntoBankAccountList(lines);
        } catch (IOException e) {
            throw new IllegalArgumentException(CAN_T_READ_FROM_FILE);
        }
    }

    public void makeTransactions(String path) {
        List<String> transactions = loadTransactions(path);
        for (String one : transactions) {
            doOneTransaction(one);
        }
    }

    private List<String> loadTransactions(String path) {
        try {
            return Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException(CAN_T_READ_FROM_FILE, e);
        }
    }

    private void doOneTransaction(String oneTransaction) {
        String[] split = oneTransaction.split(SEPARATOR);
        if (split.length > 1) {
            BankAccount one = findAccount(split[0]);
            try {
                one.setBalance(Double.parseDouble(split[1]));
            } catch (NullPointerException | NumberFormatException e) {
                throw new IllegalArgumentException(CORRUPT_TRANSACTION_FILE, e);
            }
        }
    }

    private BankAccount findAccount(String account) {
        for (BankAccount one : accounts) {
            if (account.equals(one.getAccountNumber())) {
                return one;
            }
        }
        return null;
    }

    private void putIntoBankAccountList(List<String> lines) {
        for (String one : lines) {
            String[] split = one.split(SEPARATOR);
            if (split.length > 2) {
                try {
                    accounts.add(new BankAccount(split[0], split[1], Double.parseDouble(split[2])));
                } catch (NullPointerException | NumberFormatException e) {
                    throw new IllegalArgumentException(CORRUPT_BANK_ACCOUNTS_FILE, e);
                }
            }
        }
    }

    public List<BankAccount> getAccountList() {
        return new ArrayList<>(accounts);
    }
}