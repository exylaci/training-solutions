package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.MathContext;

public class Product {
    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is a must!");
        }
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this(name, unitWeight, 2);
    }

    public BigDecimal totalWeight(int pieces) {
        BigDecimal result = unitWeight.multiply(new BigDecimal(pieces));
        double integerDigits = Math.floor(Math.log10(result.doubleValue())) + 1;
        return result.round(new MathContext(numberOfDecimals + (int) integerDigits));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }
}
