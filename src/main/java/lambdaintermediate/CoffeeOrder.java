package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> coffeeList;
    private LocalDateTime date;

    public CoffeeOrder(List<Coffee> coffeeList, LocalDateTime date) {
        this.coffeeList = coffeeList;
        this.date = date;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public LocalDateTime getDateTime() {
        return date;
    }
}
