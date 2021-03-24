package erettsegik.oktober2019.eutazas;

public enum Type {
    FEB(true, Discount.FULLPRICE, "Felnőtt bérlet"),
    TAB(true, Discount.REDUCEDPRICE, "Tanulóbérlet"),
    NYB(true, Discount.REDUCEDPRICE, "Nyugdíjas bérlet"),
    NYP(true, Discount.FREE, "65 év feletti bérlet"),
    RVS(true, Discount.FREE, "Rokkant, vak, siket vagy kísérő"),
    GYK(true, Discount.FREE, "Iskolakezdés előtti gyerekbérlet"),
    JGY(false, Discount.FULLPRICE, "Jegy");

    boolean seasonPass;
    Discount discount;
    String description;

    Type(boolean seasonPass, Discount discount, String description) {
        this.seasonPass = seasonPass;
        this.discount = discount;
        this.description = description;
    }

    public boolean isSeasonPass() {
        return seasonPass;
    }

    public Discount getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }
}
