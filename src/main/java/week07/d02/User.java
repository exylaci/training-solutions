package week07.d02;

public interface User {
    String getUsername();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    static User of2(String username, String firstname, String lastname) {
        return new UserImpl(username, firstname, lastname);
    }

    static User of(String username, String firstname, String lastname) {
        return new User() {

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getFirstName() {
                return firstname;
            }

            @Override
            public String getLastName() {
                return lastname;
            }
        };
    }
}
//Készítsünk a week07d02 csomagba egy interfészt User néven.
// Az interfésznek egyen egy
// String getUsername(), egy
// String getFirstName(), egy
// String getLastName() és egy
// String getFullName() metódusa.
// Implementáljuk az User interfészt egy UserImpl nevű osztályba,
// mely konstruktor paraméterként várja az username, a firstName és a lastName paramétereket.
// A getFullName metódushoz adjunk az interfészben egy default implementációt!

//Bónusz feladat: Készítsünk egy statikus függvényt az User interfészben of néven,
// mely létrehoz egy új User típusú objektumot! (edited)