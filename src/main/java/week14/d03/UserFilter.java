package week14.d03;

import java.util.List;

@FunctionalInterface
public interface UserFilter {
    List<User> filter(List<User> users);
}
