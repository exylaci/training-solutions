package week13.d05;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BillWriter {

    public String writeBills(List<BillItem> bills, Function<BillItem, Optional<String>> writeLine) {
        StringBuilder result = new StringBuilder();

        Optional<String> header = writeLine.apply(null);
        if (header.isPresent()) {
            result.append(header.get()).append("\n");
        }
        for (BillItem bill : bills) {
            result.append(writeLine.apply(bill).get()).append("\n");
        }
        return result.toString();
    }
}
//Legyen egy BillItem osztály, mely tartalmazza a name, number, unitPrice attribútumokat.
//Legyen egy BillWriter osztály, melynek van egy writeBills() metódusa.
//Ennek a számlatételeket egymás alatt szövegesen vissza kell adnia.
//Ennek első paramétere egy List<BillItem>, azaz megkapja a számlatételeket.
//A második paraméterét neked kell kitalálni! A lényeg, hogy bármit át tudj adni, hogy egy
//számla tételt, hogy lehet kiírni. Ugyanis van, hogy egymás után kell kiírni a 3 attribútumot,
//van, hogy tabokkal elválasztva, van, hogy mögé kell írni az összes árat is. Szóval változhat,
//gyakorlatilag a sor kiirásának algoritmusát kell paraméterül átadni.
//A visszatérési értéke egy String.Sem a BillItem, sem a BillWriter metódust nem módosíthatod, és a következő
//kiírási formákat kell megvalósítanod:
//
//3 kenyér, darabja 10 Ft
//5 tej, darabja 20 Ft
//
//Megnevezés               Egységár (Ft) Darab Összeg
//kenyer                              10     3     30
//tej                                 20     5    100
//(Megnevezés 20 karakter,
// Egységár 13 karakteren jobbra igazítva.
// Darab 5 karakteren jobbra igazítva.
// Összeg, 6 karakteren jobbra igazítva.)
//
//kenyér 3 * 10 = 30
//tej 5 * 20 = 100