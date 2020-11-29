package introinheritance.basket;

import defaultconstructor.date.CountryCode;

import java.util.Locale;

public class Item {
    public final static String ERROR_NO_BARCODE = "Barcode is a must!";
    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException(ERROR_NO_BARCODE);
        }
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public long getTaxAmount() {
        return (long) nettoPrice * vatPercent / 100;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public int getVatPercent() {
        return vatPercent;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Item{barcode='%s', nettoPrice=%.1f, vatPercent=%d}",barcode,nettoPrice,vatPercent);
    }
}
