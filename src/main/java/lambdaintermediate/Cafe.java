package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<CoffeeOrder> coffeeOrders = new ArrayList<>();

    public Cafe(List<CoffeeOrder> orders) {
        this.coffeeOrders = orders;
    }

    public BigDecimal getTotalIncome() {
        return coffeeOrders.stream().
                flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream()).
                map(coffee -> coffee.getPrice()).
                reduce(BigDecimal.valueOf(0), (price, next) -> price.add(next)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate when) {
        return coffeeOrders.stream().
                filter(coffeeOrder->coffeeOrder.getDate().toLocalDate().equals(when)).
                flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream()).
                map(coffee -> coffee.getPrice()).
                reduce(BigDecimal.valueOf(0), (price, next) -> price.add(next)).setScale(2, RoundingMode.HALF_UP);
    }
}
