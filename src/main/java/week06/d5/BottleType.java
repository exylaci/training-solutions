package week06.d5;

public enum BottleType {
    GLASS_BOTTLE(500), PET_BOTTLE(400);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
