package exam03retake01;

public class CdvCheck {
    public boolean check(String cdvNumber) {
        if (!cdvNumber.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Only 10 digit number parameter is accepted!");
        }

        int sum = 0;
        for (int i = 1; i < 10; ++i) {
            sum += i * Integer.parseInt(String.valueOf(cdvNumber.charAt(i - 1)));
        }

        return sum % 11 % 10 == Integer.parseInt(String.valueOf(cdvNumber.charAt(9)));
    }
}
//3. vizsga / 1. ismétlés / CDV
//
//Írj egy CdvCheck.check() metódust (paraméterezése, visszatérési értéke kiderül a tesztesetből), mely kap egy
// adószámot, és eldönti róla, hogy helyes-e! A következőképp kell eldönteni. Fogni kell az első kilenc számjegyet, és
// megszorozni rendre 1, 2, ..., 9 számmal. Az eredményt kell összegezni, majd maradékos osztani 11-el. A 10.
// számjegynek meg kell egyeznie ezzel a számmal (maradékkal).
//
//Pl.:
//8365670003
//1 * 8 + 2 * 3 + 3 * 6 + ... + 9 * 0 = 124
//124 maradékos osztás 11-el = 3
//3 (maradék) == 3 (10. számhegy) - az adószám megfelelő
//
//Ha a paraméterként átadott adószám nem 10 számjegy, vagy nem csak számjegy szerepel benne,
//IllegalArgumentException kivételt kell dobni.