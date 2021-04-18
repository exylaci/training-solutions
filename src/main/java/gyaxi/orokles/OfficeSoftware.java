package gyaxi.orokles;

public class OfficeSoftware extends Software {
    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        incrementPrice(5);
    }
}