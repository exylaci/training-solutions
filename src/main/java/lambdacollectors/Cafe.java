package lambdacollectors;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.orders = coffeeOrders;
    }

    public void add(CoffeeOrder order) {
        orders.add(order);
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return orders;
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
        return orders
                .stream()
                .flatMap(coffeeOrder -> coffeeOrder.getCoffees().stream())
                .collect(Collectors.groupingBy(Coffee::getType, Collectors.counting()));
    }

    public double getAverageOrder() {
        OptionalDouble result = orders
                .stream()
                .mapToInt(coffeeOrder -> coffeeOrder.getCoffees().size())
                .average();
        if (result.isPresent()) {
            return result.getAsDouble();
        }
        return 0;
    }
}
//Készíts egy Coffee osztályt! Attribútumai:
//      type a kávé típusa,
//      price a kávé ára.
// A konstruktor is ebben a sorrendben kapja meg az adatokat. Az ár lehet tört, 2 tizedesjegy pontossággal számolj!
//
//A kávé típusához készíts egy CoffeeType enum-ot. Lehetséges értékei:
//      ESPRESSO, MACHIATTO, RISTRETTO, MOCHA, LATTE, CAPPUCCINO, AMERICANO.
//
//A CoffeeOrder osztály tárolja egy vásárló által megrendelt és leszámlázott kávékat. Attibútumai:
//      coffeeList a megrendelt kávék listája,
//      dateTime a vásárlás időpontja.
//
//A Cafe osztály tartalmazza a kávézó összes rendelését egy listában. A listát a konstruktorban kapja meg, de legyen
// lehetőség új rendelést hozzáadni. Készítsd el benne az alábbi metódusokat streamek segítségével:
//      Map<CoffeeType, Long> getCountByCoffeeType(): az eladott kávék mennyiségét adja vissza kávétípusonként
//      double getAverageOrder(): átlagosan hány kávét rendelnek egyszerre