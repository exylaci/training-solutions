package week12.d04;

public class Client {
    private String name;
    private String regNumber;

    public Client(String regNumber, String name) {
        this.name = name;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }
}