package erettsegik.oktober2019.forditoiroda;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class Gui {
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
            source.setUrl("jdbc:mariadb://localhost:3306/forditoiroda?useUnicode=true");
            source.setUser("erettsegik");
            source.setPassword("erettsegik");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
        }
        logic = new Logic(source, "filesystem:src/main/resources/erettsegik/oktober2019/forditoiroda");
    }

    private void exercrise1() throws IllegalStateException {
        System.out.println("\n1.feladat");

        System.out.print("\tAdatok betöltése folyamatban.");
        logic.exercrise1("nyelv.txt", "doku.txt", "szemely.txt", "fordito.txt");
        System.out.println("\r\tAz Adatok sikeresen betőltődtek.");
    }

    private void exercrise2() {
        System.out.println("\n2.feladat - Elérhető fordítók:");

        System.out.println("\t" + String.join(", ", logic.exercrise2()));
    }

    private void exercrise3() {
        System.out.println("\n3.feladat");

        ReportData result = logic.exercrise3();
        System.out.printf("\t5000 karakternél nem hosszabb szöveheg száma: %d, fordításuk össz.költsége: %d.%n",
                result.getPieces(), result.getAmount());
    }

    private void exercrise4() {
        System.out.println("\n4.feladat - Angolról magyarra fordítandó dokumentumok:");

        System.out.printf("\t%11s %s%n", "terjedelem", "szakterulet");

        for (ReportData one : logic.exercrise4()) {
            System.out.printf("\t%11d %s%n", one.getSize(), one.getSubject());
        }
    }

    private void exercrise5() {
        System.out.println("\n5.feladat - 7-9 órányi munkát igényló dokumentumok:");

        System.out.printf("\t%-20s %12s-%s%n", "szakterulet", "forrás nyelv", "cél nyelv");

        for (ReportData one : logic.exercrise5()) {
            System.out.printf("\t%-20s %12s-%s%n", one.getSubject(), one.getSourceLanguage(), one.getTargetLanguage());
        }
    }

    private void exercrise6() {
        System.out.println("\n6.feladat - Legtöbb nyelvre fordító magyarról:");

        System.out.println("\t" + logic.exercrise6());
    }

    private void exercrise7() {
        System.out.println("\n7.feladat - Szabad fordítók magyarról - oroszra, vagy angolra:");

        System.out.println("\t" + String.join(", ", logic.exercrise7()));
    }

    private void exercrise8() {
        System.out.println("\n8.feladat - Fordítandó dokumentumok:");

        System.out.printf("\t%-20s %12s-%s%n", "szakterulet", "forrás nyelv", "cél nyelv");

        String previous = "";
        for (ReportData one : logic.exercrise8()) {
            if (!previous.equals(one.getSubject())) {
                System.out.printf("\t%-20s%n", one.getSubject());
                previous = one.getSubject();
            }
            System.out.printf("\t%-20s %12s-%s%n", "", one.getSourceLanguage(), one.getTargetLanguage());
        }
    }

}
