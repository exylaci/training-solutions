package week05.d4;


import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate expiringDate;

    public Product(String name, int year, int month,int day) {
        this.name = name;
        this.expiringDate = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }
}
