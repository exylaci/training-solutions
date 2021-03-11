package erettsegik.oktober2020.kozossegiszolgalat;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Gui {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("H:mm:ss");

    private Logic logic;

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.init();
        gui.iskolaik();
        gui.oraszamok();
        gui.teljesitettek();
        gui.tobbszor();
        gui.senki();
    }

    private void init() {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/kozossegi?useUnicode=true");
            source.setUser("erettsegik");
            source.setPassword("erettsegik");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logic = new Logic(source);
        logic.init();
        System.out.println("adatbetöltés folyamatban....");
        new FileOperations(source).loadDataFromTextFiles();
    }

    private void iskolaik() {
        System.out.println("\nAz iskolához kötött tevékenységi területek neve:");

        List<String> reports = logic.iskolaik();
        for (String report : reports) {
            System.out.println("    " + report);
        }
    }

    private void oraszamok() {
        Optional<Integer> result = logic.oraszamok();
        if (result.isEmpty()) {
            System.out.println("\nA tanév során nem volt elérhető feladat a diákok számára.");
        } else {
            System.out.printf("%nA tanév során összesen %d órányi feladat volt elérhető a diákok számára%n",
                    result.get());
        }
    }

    public void teljesitettek() {
        System.out.println("\nA 10. évfolyam tanulói által ténylegesen teljesített munkák adatai:");
        System.out.printf("%7s %-30s %11s %8s %7s %s%n", "osztály", "név", "dátum", "időpont", "óraszám", "tevékenység");

        List<Report4> reports = logic.teljesitettek();
        for (Report4 report : reports) {
            if (report.getDatum() == null) {
                System.out.printf("%7s %-30s%n", report.getOsztaly(), report.getNev());
            } else {
                System.out.printf("%7s %-30s %11s %8s %7d %s%n",
                        "",
                        "",
                        report.getDatum().format(DATE_FORMAT),
                        report.getIdopont().format(TIME_FORMAT),
                        report.getOraszam(),
                        report.getTevekenyseg());
            }
        }
    }

    private void tobbszor() {
        System.out.println("\nEzek a diákokkal legalább kétszer előfordult, hogy jelentkezésüket elfogadták, de nem teljesítették a választott feladatot:");

        List<Report5> reports = logic.tobbszor();
        for (Report5 report : reports) {
            System.out.printf("%30s %2d%n", report.getNev(), report.getTavlomaradasok());
        }
    }

    private void senki() {
        System.out.println("\nEzek az őszi szünetre eső munkákra nem volt még jelentkező:");
        System.out.printf("    %-11s %-8s %5s %s%n", "datum", "kezdes", "hossz", "tevékenység");

        List<Report6> reports = logic.senki();
        for (Report6 report : reports) {
            System.out.printf("    %11s %8s %5d %s%n",
                    report.getDatum().format(DATE_FORMAT),
                    report.getIdopont().format(TIME_FORMAT),
                    report.getOraszam(),
                    report.getTevekenyseg());
        }
    }

    private void stat() {
        System.out.println("\nEnnyien teljesítettek már közösségi munkát:");
        System.out.printf("    %-7s %-3s", "osztály", "fő");

        Map<String, Integer> reports = logic.stat();
        for (Map.Entry<String, Integer> report : reports.entrySet()) {
            System.out.printf("    %-7s %3d%n",
                    report.getKey(),
                    report.getValue());
        }
    }
}