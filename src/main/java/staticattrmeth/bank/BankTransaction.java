package staticattrmeth.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankTransaction {
    public static final String ERROR_MESSAGE = "Amount is out of permitted range!";
    private static long currentMaxValue = 0;
    private static long currentMinValue = 0;
    private static BigDecimal currentTotalValue = new BigDecimal(0);
    private static int numberOfTransactions = 0;

    private long transaction;

    public BankTransaction(long transaction) {
        if (transaction < 1 || transaction > 10_000_000) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (transaction < currentMinValue || numberOfTransactions == 0) {
            currentMinValue = transaction;
        }
        if (transaction > currentMaxValue || numberOfTransactions == 0) {
            currentMaxValue = transaction;
        }

        ++numberOfTransactions;
        currentTotalValue = currentTotalValue.add(new BigDecimal(transaction));
        this.transaction = transaction;
    }

    public static void initTheDay() {
        numberOfTransactions = 0;
        currentTotalValue = new BigDecimal(0);
        currentMaxValue = 0;
        currentMinValue = 0;
    }

    public static BigDecimal averageOfTransaction() {
        return currentTotalValue.divide(new BigDecimal(numberOfTransactions));
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return currentTotalValue;
    }

    public long getTrxValue() {
        return transaction;
    }
}
