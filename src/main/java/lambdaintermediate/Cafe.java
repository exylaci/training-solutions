package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(when)).
                flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream()).
                map(coffee -> coffee.getPrice()).
                reduce(BigDecimal.valueOf(0), (price, next) -> price.add(next)).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType coffeeType) {
        return coffeeOrders
                .stream()
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .filter(coffee -> coffee.getType() == coffeeType)
                .collect(Collectors.counting());
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime dateTime) {
        return coffeeOrders
                .stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().isAfter(dateTime))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate localDate) {
        return coffeeOrders
                .stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(localDate))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }
}
//Készíts egy Coffee osztályt!
// Attribútumai: type a kávé típusa, price a kávé ára. A konstruktor is ebben a sorrendben kapja meg az adatokat.
// Az ár lehet tört, 2 tizedesjegy pontossággal számolj!
//
//A kávé típusához készíts egy CoffeeType enum-ot.
// Lehetséges értékei: ESPRESSO, MACHIATTO, RISTRETTO, MOCHA, LATTE, CAPPUCCINO, AMERICANO.
//
//A CoffeeOrder osztály tárolja egy vásárló által megrendelt és leszámlázott kávékat.
// Attibútumai: coffeeList a megrendelt kávék listája, dateTime a vásárlás időpontja.
//
//A Cafe osztály tartalmazza a kávézó összes rendelését egy listában.
// A listát a konstruktorban kapja meg, de legyen lehetőség új rendelést hozzáadni.
// Készítsd el benne az alábbi metódusokat streamek segítségével:
//
//  getTotalIncome(): az eddigi összes bevétel
//  getTotalIncome(LocalDate date): adott napi teljes bevétel
//  getNumberOfCoffee(CoffeeType type): az adott típusú kávéból eladott összmennyiség
//  getOrdersAfter(LocalDateTime from): a megadott időpont utáni rendelések listája
//  getFirstFiveOrder(LocalDate date): adott napon az első 5 vásárlásban lévő kávék listája