package week04.d01;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName) {
        int pos = fullName.indexOf(' ');
        if (pos > 0) {
            fullName = firstName + fullName.substring(pos);
        }
    }

    public String getFullName() {
        return fullName;
    }
}
//Készítsd el a NameChanger osztályt, melynek privát attribútuma legyen a
// String fullName, mely egy ember teljes nevét reprezentálja! A
// fullName attribútum [vezetéknév][szóköz][keresztnév] formátumban épül fel.
// A konstruktor állítsa be a paraméterül kapott értékre az adattagot,
//  de ha az érték null, vagy üres String, akkor
//  dobjon egy IllegalAgrumentException kivételt a következő üzenettel: Invalid name:[paraméter értéke]!
//
//Legyen egy changeFirstName(String firstName) metódusa, mely
// megváltoztatja az objektum állapotát és kicseréli a vezetéknevet a paraméterül kapott értékre!