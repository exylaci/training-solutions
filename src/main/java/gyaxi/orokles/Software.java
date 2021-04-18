package gyaxi.orokles;

public abstract class Software {
    private String name;
    private int price;

    Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void increasePrice();

    protected void incrementPrice(int percent) {
        price = price * (100 + percent) / 100;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
// Hozzatok létre egy Software osztályt, melynek van egy name attribútuma! Legyen egy price attribútuma is!
// Ne lehessen példányosítani! Legyen egy  void increasePrice() metódusa!
// Legyen konstruktora, mely a két attribútum értékét várja! Kell getter is a két attribútumhoz.
// Hozzatok létre egy OfficeSoftware és egy DeveloperSoftware osztályt, mely a Software leszármazottja.
// Legyen egy increasePrice() metódusa, mely OfficeSoftware  esetén az árat 5%-kal, a DeveloperSoftware árát 10%-kal emeli.
// Írj a két leszármazotthoz teszteseteket!
// Nem használhatsz settert