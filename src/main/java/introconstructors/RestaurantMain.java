package introconstructors;

import java.util.Arrays;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Késdobáló", 4);

        System.out.println(restaurant.getName() + ", " +
                restaurant.getCapacity() + " fő, menü: " +
                restaurant.getMenu());
    }
}
