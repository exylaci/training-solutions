package initalizer;

public class Rate {
    private Currency currency;
    private Double conversionFactor;

    public Rate(Currency currency, Double conversionFactor) {
        this.currency = currency;
        this.conversionFactor = conversionFactor;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }
}

