package countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    public static final String SEPARATOR = " ";
    public static final String THIS_FILE_IS_CORRUPT = "This file is corrupt!";
    public static final String CAN_T_READ_FROM_THIS_FILE = "Can't read from this file!";

    private List<Country> countries = new ArrayList<>();

    public void readFromFile(String path) {
        countries.clear();
        String oneLine;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(path)));
            while ((oneLine = reader.readLine()) != null) {
                countries.add(convertToCountry(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalStateException(CAN_T_READ_FROM_THIS_FILE, e);
        }
    }

    private Country convertToCountry(String oneLine) {
        String[] split = oneLine.split(SEPARATOR);
        if (split.length > 0) {
            return new Country(split[0], parse(split[1]));
        }
        throw new IllegalStateException(THIS_FILE_IS_CORRUPT);
    }

    private int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(THIS_FILE_IS_CORRUPT);
        }

    }

    public Country mostBorderCountries() {
        Country result = null;
        int max = -1;
        for (Country one : countries) {
            if (one.getBorderCountries() > max) {
                max = one.getBorderCountries();
                result = one;
            }
        }
        return result;
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countries);
    }
}
//A src/main/resources/country.txt állományban országnevek és a szomszédos országok száma található.
// Hozz létre egy az ország tárolására alkalmas osztályt Country néven!
//
//Hozz létre egy CountryStatistics osztályt, ahol
// beolvasod file tartalmát egy listába, majd
// írj metódusokat amelyek visszatérési értéke választ ad a következő kérdésekre:
// * Hány országot olvastál be?
// * Melyik országnak van a legtöbb szomszédja?