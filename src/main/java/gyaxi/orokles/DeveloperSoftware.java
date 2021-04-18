package gyaxi.orokles;

public class DeveloperSoftware extends Software {
    public DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        incrementPrice(10);
    }
}