package initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCard {
    public static final String ERROR_MESSAGE = "Currency cannot be null!";
    private long balance;
    private Currency currency;
    private static List<Rate> rates;

    static {
        List<Rate> actualRates = new ArrayList<>(Arrays.asList(
                new Rate(Currency.HUF, 1.),
                new Rate(Currency.EUR, 308.23),
                new Rate(Currency.SFR, 289.24),
                new Rate(Currency.GBP, 362.23),
                new Rate(Currency.USD, 289.77)
        ));
        rates = actualRates;
    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        this(balance, currency);
        this.rates = rates;
    }

    public CreditCard(long balance, Currency currency) {
        checkCurrency(currency);
        this.balance = (long) (balance * getRate(currency));
        this.currency = currency;
    }

    public CreditCard(long balance) {
        this(balance, Currency.HUF);
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        checkCurrency(currency);
        long newAmount = (long) Math.floor(balance - amount * getRate(currency));
        if (newAmount < 0) {
            return false;
        }
        balance = newAmount;
        return true;
    }

    private void checkCurrency(Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private double getRate(Currency currency) {
        for (Rate one : rates) {
            if (one.getCurrency() == currency) {
                return one.getConversionFactor();
            }
        }
        return 0;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }
}
