package stringbasic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vet {
    List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    //Ez a metódus nem volt feladat, de már csak a megírása után tudtam meg, hogy
    //van hozzá teszter, amiből kiderült, hogy nem kell adatokat bekérni.
    //Úh meghagytam az adatbekérést is, paraméter nélküli metódus hívás esetén. :)
    public void add(){
        add(askPetData());
    }

    public void add(Pet pet) {
        boolean exists = false;

        for (Pet onePet : pets) {
            if (areEquals(pet, onePet)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            pets.add(pet);
        }
    }

    private Pet askPetData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("neve:");
        String name = scanner.nextLine();

        System.out.println("születési év:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("hónap:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("nap");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate birth = LocalDate.of(year,month,day);

        System.out.println("registration number:");
        String registrationNumber = scanner.nextLine();
        while (registrationNumber.length()<Pet.MAX_LENGTH_OF_REGISTRATIONNUMBER){
            registrationNumber = "0" + registrationNumber;
        }

        System.out.println("sex: " + GENDER.values() );
        GENDER gender;
        String sexString = scanner.nextLine();
        switch (sexString.toLowerCase().charAt(0)){
            case 'm' :
                gender = GENDER.MALE;
                break;
            case 'f' :
                gender = GENDER.FEMALE;
            default :
                gender = GENDER.UNKNOWN;
        }
        return new Pet(name, birth, gender, registrationNumber);
    }

    private boolean areEquals(Pet pet1, Pet pet2){
        return pet1.registrationNumber.equals(pet2.registrationNumber);
    }
}
//A Vet osztály tartalmazza egy adott orvoshoz tartozó kisállatok listáját.

// Készíts egy add() metódust, mely az újonnan érkező kisállatot adja a listához, de csak akkor, ha még nincs ott!
// Ennek vizsgálatára készíts egy privát areEquals() metódust,
//  mely a paraméterül kapott két kisállat egyezőségét adja vissza!
//  Két kedvenc akkor tekinthető ugyanannak, ha ugyanaz a regisztrációs számuk.
// A listához készíts gettert!