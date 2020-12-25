package week05.d05;


public class User {
    public static final String EMAIL_MUST_CONTAINS_AND_CARACTERS = "Email must contains @ and . caracters!";
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException(EMAIL_MUST_CONTAINS_AND_CARACTERS);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName(){
        return String.format("%s %s",firstName,lastName);
    }
}
//Készíts egy osztályt User néven, melynek van egy
//  firstName (String), egy
//  lastName (String) és egy email (String) mezője!
//
// Legyen ellenőrzés a User konstruktorában,
//  mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben!
//
// Készíts egy metódust is getFullName() névvel, mely visszaadja a firstName és a lastName változókat összefűzve.
// Legyen közöttük egy whitespace (" ").