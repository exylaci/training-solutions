package week13.d05;

public class BillItem {
    private String name;
    private int unitPrice;
    private int pieces;

    public BillItem(String name, int unitPrice, int pieces) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getPieces() {
        return pieces;
    }
}