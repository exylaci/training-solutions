package pets;

import java.time.LocalDate;

public class Pet {
    public static final int MAX_LENGTH_OF_REGISTRATIONNUMBER = 6;

    String name;
    LocalDate birth;
    String registrationNumber;
    GENDER gender;

    public Pet(String name, LocalDate birth, GENDER gender, String registrationNumber) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth(){
        return birth;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public GENDER getSex() {
        return gender;
    }
}
//Tervezz meg egy házi kedvencek adatainak nyilvántartására szolgáló Pet osztályt!
// Minden kedvencnek van neve, születési ideje, neme és regisztrációs száma.
//  A neme csak hím, nőstény vagy ismeretlen lehet.
//  A regisztrációs száma mindig egy 6 jegyű szám, például 000147.
//  Melyik attribútuma milyen típusú legyen?
//
//Készíts gettereket minden attribútumhoz!