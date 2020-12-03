package inheritancemethods.products;

import java.math.BigDecimal;

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
        return unitWeight.multiply(new BigDecimal(pieces));
    }

    private void checkName(String name) {
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
