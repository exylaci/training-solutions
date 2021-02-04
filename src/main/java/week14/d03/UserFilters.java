package week14.d03;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        // TODO

        return users -> {
            Iterator<User> userIterator = users.iterator();
            while (userIterator.hasNext()) {
                User user = userIterator.next();
                boolean shouldRemove = false;
                for (Predicate<User> predicate : predicates) {
                    if (!predicate.test(user))
                        shouldRemove = true;
                }
                if (shouldRemove) {
                    userIterator.remove();
                }
            }
            return users;
        };
    }

    public UserFilter createFilterStream(List<Predicate<User>> predicates) {
        // TODO

//        Predicate<User> reduce =predicates.stream().reduce(a->true, Predicate::and);
//        Function<User,Boolean> fn = predicates.stream().reduce(a->true,Predicate::and)::test;
//        return users->users.stream().filter(reduce).collect(Collectors.toList());

        return users -> users
                .stream()
                .filter(predicates
                        .stream()
                        .reduce(a -> true, Predicate::and))
                .collect(Collectors.toList());
    }

}