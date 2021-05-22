package erettsegik.oktober2018.laprendeles;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Logic {

    private Dao dao;

    public Logic(DataSource dataSource) {
        dao = new Dao(dataSource);
    }

    public void upLoad(String lap, String elofizeto, String elofizetes) {
        dao.initialisation();

        loadLap(lap);
        loadElofizeto(elofizeto);
        loadElofizetes(elofizetes);

    }

    private void loadLap(String lap) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(lap))) {
            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                dao.addLap(Lap.parse(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + lap, e);
        }
    }

    private void loadElofizeto(String elofizeto) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(elofizeto))) {
            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                dao.addElofizeto(Elofizeto.parse(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + elofizeto, e);
        }
    }

    private void loadElofizetes(String elofizetes) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(elofizetes))) {
            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                dao.addElofizetes(Elofizetes.parse(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + elofizetes, e);
        }
    }

    public Map<String, Integer> havi2() {
        return dao.havi2();
    }

    public List<Elofizeto> tobb3() {
        return dao.tobb3();
    }

    public int osszesen4(String street, String houseNumber) {
        return dao.osszesen4(street, houseNumber);
    }

    public String kedvezmeny5() {
        return dao.kedvezmeny5();
    }

    public List<String> egyutt6(String title) {
        return dao.egyutt6(title);
    }

    public Map<Elofizeto, String> heti7() {
        return dao.heti7();
    }

    public List<Lap> ritkan8() {
        return dao.ritkan8();
    }
}
//A lapkézbesítők – előzetes rendelések alapján – az újságokat, a magazinokat és más periodikákat megadott címekre viszik
//ki. A hírlapok és a megrendelők néhány adata áll rendelkezésre a lap.txt, az elofizeto.txt és az elofizetes.txt állományban.
//
//Táblák:
//lap (id, tema, cim, havi, negyedeves, feleves, eves, gyakorisag)
//    id - A lap azonosítója (szám), ez a kulcs temaTéma kategória, amelybe a lap tartozik (szöveg)
//    cim - A lap címe (szöveg)
//    havi - A lap havi előfizetési díja (szám) – ha nem választható, akkor üres
//    negyedeves - Negyedéves előfizetési díja (szám) – ha nem választható, akkor üres
//    feleves - Féléves előfizetési díja (szám) – ha nem választható, akkor üres
//    eves - Éves előfizetési díja (szám)
//    gyakorisag - A lap évi megjelenési száma (szám) – hetilap 52-szer, napilap 300-nál többször jelenik meg évente
//elofizetes (id, eloid, lapid)
//    id - A rendelés azonosítója (számláló), ez a kulcs
//    eloid - Az előfizető azonosítója (szám)
//    lapid - A lap azonosítója (szám)
//elofizeto (id, nev, utca, hazszam)
//    id - Az előfizetős azonosítója (szám), ez a kulcs
//    nev - Az előfizető neve (szöveg) – azonos nevűek lehetségesek
//    utca - A kézbesítési cím utcája (szöveg)
//    hazszam - A kézbesítési cím házszáma (szöveg)
//
//A következő feladatok megoldásánál a lekérdezéseket és a jelentést a zárójelben olvasható néven mentse! Ügyeljen arra,
//hogy a lekérdezésekben pontosan a kívánt mezők szerepeljenek, felesleges mezőt ne jelenítsen meg!
//
//1.Készítsen új adatbázist kezbesito néven! A mellékelt állományokat importálja az adatbázisba a fájlnévvel azonos
//táblanéven! Az állományok tabulátorral tagolt, UTF-8 kódolású szövegfájlok, az első soruk a mezőneveket tartalmazza.
//A létrehozás során állítsa be a megfelelő típusokat és a kulcsokat! Az elofizetes táblához adjon hozzá id néven egyedi
//azonosítót!
//
//2.Lekérdezés segítségével sorolja fel azoknak a lapoknak a címét és a havi előfizetési díját, amelyeket meg lehet
//rendelni havi előfizetéssel! A lista cím szerint rendezve jelenjen meg! (2havi)
//
//3.Készítsen lekérdezést, amely megadja azoknak az előfizetőknek nevét, utcáját és házszámát, akik legalább négy lapra
//fizettek elő! (3tobb)
//
//4.Mennyit fizetnének együttesen a Bodor utca 13. számú ház lakói, ha valamennyi (általuk választott) lapot éves
//előfizetéssel rendelnék meg? A választ lekérdezés készítésével adja meg! (4osszesen)
//
//5.Melyik lapnál jár a legnagyobb összegű kedvezmény éves előfizetés esetén a 12 havi fizetéshez képest? Adja meg
//lekérdezés segítségével a lap címét és a kedvezmény összegét! (5kedvezmeny)
//
//6.Sorolja fel lekérdezés segítségével, hogy a „Magyar Nemzet” előfizetői milyen más lapokat rendeltek még meg!
//Biztosítsa, hogy a listában a Magyar Nemzet ne jelenjen meg, és minden más lap címe is csak egyszer! (6egyutt)
//
//7.Egészítse ki a zárójelben a lekérdezést úgy, hogy megadja azoknak az előfizetőknek az adatait és megrendelt lapjait,
//akik csak hetilapot rendeltek! A kiegészített lekérdezést mentse! (7heti)
//    SELECT elofizeto.nev, utca, hazszam, lap.cim
//    FROM lap, elofizeto, elofizetes
//    WHERE elofizeto.id = elofizetes.eloid AND lap.id = elofizetes.lapid AND eloid Not IN ( ... )
//
//8.Készítsen jelentést azokról a lapokról, amelyek évente legfeljebb 12-szer jelennek meg! A listában a lapok téma,
//azon belül a megjelenés gyakorisága szerint legyenek csoportosítva, valamint a címek ábécérendben jelenjenek meg!
//A jelentés létrehozását lekérdezéssel vagy ideiglenes táblával készítse elő! A jelentés elkészítésekor a mintából a
//mezők sorrendjét, a címet és a mezőnevek megjelenített szövegét vegye figyelembe! A jelentés formázásában a mintától
//eltérhet. (8ritkan)