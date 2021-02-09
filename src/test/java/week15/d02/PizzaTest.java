package week15.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    static Pizza pizza = new Pizza();

    @BeforeAll
    public static void init() {
        pizza.readFromFile(Path.of("src/main/resources/week15/d02/orders.txt"));
    }

    @Test
    void readFileTest() {
        assertEquals(16, pizza.getOrders().size());
    }

    @Test
    void getMinOrderDayTest() {
        assertEquals(LocalDate.of(2020, 12, 3), pizza.getMinOrderDay());
    }

    @Test
    void getMinOrderDayEmptyTest() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Pizza(List.of()).getMinOrderDay());
        assertEquals("There is no orders!", exception.getMessage());
    }

    @Test
    void makeCourierStatisticTest() {
        Map<String, Long> result = pizza.makeCourierStatistic();
        assertEquals(4, result.size());
        assertEquals(5L, result.get("FUT_2"));
    }

    @Test
    void makeCourierStatisticEmptyTest() {
        assertEquals(0, new Pizza(List.of()).makeCourierStatistic().size());
    }

    @Test
    void getMostFrequentlyAddressTest() {
        assertTrue(pizza.getMostFrequentlyAddress().matches("11[0-9]{2} Kossuth [0-9]{1,2}"));
    }

    @Test
    void getMostFrequentlyAddressEmptyTest() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Pizza(List.of()).getMostFrequentlyAddress().matches("nowhere"));
        assertEquals("There is no orders!", exception.getMessage());
    }

    @Test
    void getOrderByDateAndTimeTest() {
        assertEquals("1144 Tököly 11", pizza.getOrderByDateAndTime(
                LocalDate.of(2020, 12, 01), LocalTime.of(16, 33))
                .get().getAddress());
    }

    @Test
    void getOrderByDateAndTimeEmptyListTest() {
        assertEquals(Optional.empty(), new Pizza(List.of()).getOrderByDateAndTime(
                LocalDate.of(2020, 12, 01), LocalTime.of(16, 33)));
    }

    @Test
    void getOrderByDateAndTimeNotExistsTest() {
        assertEquals(Optional.empty(), pizza.getOrderByDateAndTime(
                LocalDate.of(2020, 12, 01), LocalTime.of(11, 33)));
    }
}