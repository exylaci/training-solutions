package week14.d04;

import java.util.List;

@FunctionalInterface
public interface UserFilter {
    List<User> filter(List<User> users);
}
