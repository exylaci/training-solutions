package erettsegik.majus2020.akademikusok;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Gui {
    Scanner scanner;
    Logic logic;
    FileOperation fileOperation;

    public static void main(String[] args) {

        Gui gui = new Gui();

        try {
            gui.feladat1();
            gui.feladat2();
            gui.feladat3();
            gui.feladat4();
            gui.feladat5();
            gui.feladat6();
            gui.feladat7();
            gui.feladat8();
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }

    private void init() {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/akademikusok?useUnicode=true");
            source.setUser("erettsegik");
            source.setPassword("erettsegik");
        } catch (SQLException e) {
            System.out.println("Nem lehet az adatbázishoz csatlakozni!");
        }

        logic = new Logic(source);
        fileOperation = new FileOperation(source);
        scanner = new Scanner(System.in);
    }

    private void clean() {
        logic.clean();
    }

    private void load() {
        fileOperation.loadDataFromTextFile();
    }


    private void feladat1() {
        System.out.println("\n1. feladat");

        init();
        clean();
        System.out.print("\tadatok betöltése...");
        load();

        System.out.println("\r\tAz adatok sikeresen betöltődtek.");
    }

    //Készítsen lekérdezést, amely ábécérendben megjeleníti a rögzített adatok alapján az MTA élő akadémikusait!
    private void feladat2() {
        System.out.println("\n2. feladat");

        List<String> names = logic.feladat2();

        for (String name : names) {
            System.out.println("\t" + name);
        }

    }

    //Készítsen lekérdezést azon akadémikusok rendes vagy levelező taggá választásáról, akik nem vagy nem csak magyar
    //identitással rendelkeztek! Az akadémikus nevét, identitását, a tagság  típusát  és  a  megválasztás  évét
    //jelenítse  meg  a  megválasztás  éve  szerinti sorrendben!
    private void feladat3() {
        System.out.println("\n3. feladat");

        List<Report3> result = logic.feladat3();

        System.out.printf("\t%-55s %-26s %s %s%n", "név", "identitás", "tipus", "év");
        for (Report3 one : result) {
            System.out.printf("\t%-55s %-30s %s %d%n", one.getNev(), one.getIdentitas(), one.getTipus(), one.getEv());
        }
    }

    //Készítsen  lekérdezést,  amely  megadja,  hogy  az  egyes  tagokat,  mikor  választották  meg először az akadémia tagjává! ü
    private void feladat4() {
        System.out.println("\n4. feladat");

        List<Report4> result = logic.feladat4();
        System.out.printf("\t%-55s %s%n", "nev", "év");
        for (Report4 one : result) {
            System.out.printf("\t%-55s %d%n", one.getNev(), one.getEv());
        }

    }

    //Készítsen lekérdezést, amely megadja, hogy az akadémia eddigi tagjai között mi a nők aránya!
    // Az eredményt nem szükséges százalékos formában megjelenítenie.
    private void feladat5() {
        System.out.println("\n5. feladat");

        System.out.printf("\tA nők aránya: %2.2f%%%n", logic.feladat5());
    }

    //Sok tagot először levelező tagként választottak az akadémikusok közé, majd néhány év elteltével rendes tagok lettek.
    //Készítsen lekérdezést, amely megadja, hogy ők átlagosan hány évig voltak levelező tagok, mielőtt rendes taggá
    //választották őket! Ügyeljen arra, hogy előfordulhatnak azonos nevű akadémikusok!
    private void feladat6() {
        System.out.println("\n6. feladat");

        System.out.printf("\tÁtlagosan %2.2f évig levelező tag valaki mielőtt rendes taggá választanák.%n", logic.feladat6());
    }

    //Egészítse ki az alábbi lekérdezést a három jelölt helyen úgy, hogy megadja, kik voltak Teller Ede tiszteleti
    //tagsága teljes ideje alatt mindvégig az akadémia tiszteleti tagjai!
    private void feladat7() {
        System.out.println("\n7. feladat");

        List<Report4> names = logic.feladat7();
        System.out.printf("\t%-55s %s%n", "nev", "ev");
        for (Report4 one : names) {
            System.out.printf("\t%-55s %d%n", one.getNev(), one.getEv());
        }
    }

    //Készítsen jelentést a XX. században (1901 és 2000 között) megválasztott rendes tagokról! A  tagokat  megválasztás
    //éve  szerint  csoportosítsa,  azon  belül  név  szerint  rendezze! A szövegszerű  tartalmat  és  a  mezők
    //sorrendjét  tekintve  az  alábbi  minta  legyen a meghatározó!  Biztosítsa,  hogy  minden  érték  látható  legyen!
    //A jelentést  lekérdezéssel készítse elő!
    private void feladat8() {
        System.out.println("\n8. feladat");

        List<Report8> result = logic.feladat8();
        System.out.printf("\t év  %-30s %s%n", "nev", "élt");
        int ev = -1;
        for (Report8 one : result) {
            if (ev != one.getEv()) {
                System.out.println("\t" + one.getEv());
                ev = one.getEv();
            }
            System.out.printf("\t     %-30s %s%n", one.getNev(), one.getElt());
        }
    }
}