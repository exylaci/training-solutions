package week05.d03;

import java.util.List;

public class UserValidator {

    public boolean validate(List<User> users) {
        if (users == null || users.size() == 0) throw new IllegalArgumentException("List cannot be empty!");

        for (User user : users) {
            if (user.getName() == null || user.getName().isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty!");
            }
            if (user.getAge() < 0 || user.getAge() > 120) {
                throw new IllegalArgumentException("Age must be between 0 and 120!");
            }
        }

        return true;
    }
}
//A UserValidator osztályba írj egy
// validate(List<User>) metódust,
// mely leellenőrzi a paraméterben átadott felhasználókat!
// (A User egy String name és egy int age attribútumot tartalmazzon!)
// Ha a lista null, dobjon kivételt!
// Ha a felhasználó null, dobjon kivételt!
// Ha A felhasználó neve null, vagy üres, dobjon kivételt!
// Ha az életkor kisebb, mint 0, vagy nagyobb, mint 120, dobjon kivételt!