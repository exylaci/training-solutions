package enumtype;

public enum Coin {
    KETSTAZAS(200,"kétszínű"),
    SZAZAS(100,"kétszínű"),
    OTVENES(50,"ezüst színű"),
    HUSZAS(20,"arany színű"),
    TIZES(10,"fényes"),
    OTOS(5,"sárga");

    private final int value;
    private final String description;

    Coin(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return name()+"(" + value + ")" +  description;
    }
}
