package week06.d02;

public class Quantity {
    private Category category;
    private int pieces;

    public Quantity(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category is a must!");
        }
        this.category = category;
    }

    public void inrementPieces() {
        ++pieces;
    }

    public int getPieces() {
        return pieces;
    }

    public Category getCategory() {
        return category;
    }
}