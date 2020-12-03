package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.MathContext;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        BigDecimal result = super.totalWeight(pieces).
                add(new BigDecimal(Math.ceil((double) pieces / packingUnit)).multiply(weightOfBox));
        double integerDigits = Math.floor(Math.log10(result.doubleValue())) + 1;
        return result.round(new MathContext(super.getNumberOfDecimals() + (int) integerDigits));
    }
}