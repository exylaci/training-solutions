package week14.d04;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final UserFilter filter = new UserFilters().createFilter(Arrays.asList(
                (user) -> user.getAge() > 18,
                (user) -> user.getName().startsWith("A")
        ));
        System.out.println(filter.filter(new ArrayList<>(Arrays.asList(
                new User("Anna", 16, "Racz Aladar utca 99/b"),
                new User("Marton", 16, "Racz Aladar utca 99/b"),
                new User("Mihály", 19, "Racz Aladar utca 99/b"),
                new User("Attila", 19, "Kazmer utca 4")
        ))));
    }
}
//Adott egy User osztály:
//
//és egy UserFilter interfész:
//
//@FunctionalInterface
//public interface UserFilter {    List<User> filter(List<User> users);
//}
//
//Készíts hozzá egy UserFilters osztályt, mely filter objektumokat képes gyártani az alábbi módon lambdak felhasznalasaval:
//
//java
//public class UserFilters {    public UserFilter createFilter(List<Predicate<User>> predicates) {
//        // TODO
//    }
//}
//
//Példa:
//public class Main {    public static void main(String[] args) {
//        final UserFilter filter = new UserFilters().createFilter(Arrays.asList(
//                (user) -> user.getAge() > 18,
//                (user) -> user.getName().startsWith("A")
//        ));        System.out.println(filter.filter(new ArrayList<>(Arrays.asList(
//                new User("Marton", 16, "Racz Aladar utca 99/b"),
//                new User("Attila", 19, "Kazmer utca 4")
//        ))));
//    }
//}