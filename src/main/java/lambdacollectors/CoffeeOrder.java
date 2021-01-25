package lambdacollectors;

import java.time.LocalDateTime;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffees, LocalDateTime dateTime) {
        this.coffees = coffees;
        this.dateTime = dateTime;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}