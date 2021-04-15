package erettsegik.majus2019.urhajozas;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Gui {
    Scanner scanner;
    Logic logic;

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.init();

        try {
            gui.exercrise1();
            gui.exercrise2();
            gui.exercrise3();
            gui.exercrise4();
            gui.exercrise5();
            gui.exercrise6();
            gui.exercrise7();
            gui.exercrise8();

        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }

    private void init() {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/urhajozas?useUnicode=true");
            source.setUser("erettsegik");
            source.setPassword("erettsegik");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
        }
        logic = new Logic(source);
        scanner = new Scanner(System.in);
    }

    private void exercrise1() {
        System.out.println("\n1. feladat - Táblák létrehozása, adatok betöltése:");

        logic.load("urhajos.txt", "urhajos");
        logic.load("kuldetes.txt", "kuldetes");
        logic.load("repules.txt", "repules");
        System.out.println("\tAz adattáblák feltöltve");
    }

    private void exercrise2() {
        System.out.println("\n2. feladat:");

        Urhajos result = logic.legtobbido();

        System.out.printf("\t%s töltötte a legtöbb időt az űrben: %s%n",
                result.getName(), result.getSpentTime());
    }

    private void exercrise3() {
        System.out.println("\n3. feladat - Szilveszteri küldetések:");

        List<Szilveszter> result = logic.szilveszter();

        System.out.printf("\t%-15s %S%n", "Megnevezés", "Hossz");
        for (Szilveszter szilveszter : result) {
            System.out.printf("\t%-15s %3d%n", szilveszter.getMegnevezes(), szilveszter.getNap());
        }
    }

    private void exercrise4() {
        System.out.println("\n4. feladat - Több űrrepülésen résztvett űrhajósok:");

        List<TobbUrrepules> result = logic.eletkor();

        System.out.printf("\t%-22s %4s-%s%n", "Név", "első", "utolsó");
        for (TobbUrrepules tobbUrrepules : result) {
            System.out.printf("\t%-24s %2d-%2d%n",
                    tobbUrrepules.getName(), tobbUrrepules.getFirst(), tobbUrrepules.getLast());
        }
    }

    private void exercrise5() {
        System.out.println("\n5. feladat - Űrhajósok száma országonként:");

        List<UrhajosSzam> result = logic.urhajosszam();

        System.out.printf("\t%6s %4s%n", "ország", "fő");
        for (UrhajosSzam urhajosSzam : result) {
            System.out.printf("\t%6s %4d%n",
                    urhajosSzam.getName(), urhajosSzam.getPieces());
        }
    }

    private void exercrise6() {
        System.out.println("\n6. feladat:");

        int result = logic.orszagszam();

        System.out.printf("\t%d ország képviseletében jártak az űrben.%n", result);
    }

    private void exercrise7() {
        System.out.println("\n7. feladat - Férfi és nő is volt az asztronauták között:");

        List<String> result = logic.ferfino();

        System.out.println("\tküldetés neve");
        for (String kuldetes : result) {
            System.out.println("\t" + kuldetes);
        }
    }

    private void exercrise8() {
        System.out.println("\n8. feladat - Küldetések (1991-2000):");

        System.out.printf("%-20s %-11s %-22s %6s %s%n", "küldetés neve", "kezdete", "legénység", "ország", "nem");
        String previousMission = "";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
        for (Crew crew : logic.legenyseg()) {
            if (!crew.getMissionName().equals(previousMission)) {
                System.out.printf("%-20s %11s%n", crew.getMissionName(), dateFormat.format(crew.getMissionDate()));
                previousMission = crew.getMissionName();
            }
            System.out.printf("%20s %11s %-25s %3s %s%n",
                    "", "", crew.getAstronautName(), crew.getCountry(), crew.getSex().getDescription());
        }
    }
}