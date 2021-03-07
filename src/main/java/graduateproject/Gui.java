package graduateproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Gui {
    public static final String QUESTION_ZIP = "Irányítószám: ";

    private Logic logic;
    private Validate validate;
    private Scanner scanner = new Scanner(System.in);

    public Gui() {
    }

    public Gui(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.initialize();

        String selection;
        do {
            gui.printMenu();
            selection = gui.scanner.nextLine().trim() + " ";
            switch (selection.charAt(0)) {
                case '1':
                    gui.registration();
                    break;
                case '2':
                    gui.registrationFromFile();
                    break;
                case '3':
                    gui.generate();
                    break;
                case '4':
                    gui.vaccinate();
                    break;
                case '5':
                    gui.report();
                    break;
                case '6':
                    System.out.println("Viszlát és kössz a halakat!");
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
            }

        } while (!selection.startsWith("6"));
    }

    private void printMenu() {
        System.out.print("""

                **************************
                * Regisztráció menedzser *
                **************************
                1. Regisztráció
                2. Tömeges regisztráció
                3. Oltásra behívó generálás
                4. Oltás rögzítése
                5. Riport
                6. Kilépés
                                
                Válasszon! """);
    }

    //Csak a tesztelés miatt public, élesben private
    public void initialize() {
        System.out.println("Inicializálás. Kérem, várjon...");
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
            source.setUser("vaccine");
            source.setPassword("vaccine");
            logic = new Logic(source);
            logic.initialize();
            validate = new Validate(source);
        } catch (SQLException | IllegalStateException e) {
            System.out.println("Nem lehet az adatbázishoz csatlakozmi. A program leáll!");
            throw new IllegalStateException("Can't connect to GRADUATE_PROJECT database!", e);
        }
    }


    //Csak a tesztelés miatt public, élesben private
    public void registration() {
        System.out.println("Adja meg az adatait!");
        Citizen current = new Citizen();
        try {
            current.setName(ask("Név: ", "Hibás név!",
                    a -> validate.checkName(a)));
            current.setZip(ask(QUESTION_ZIP, "Nem létező irányítószám!",
                    a -> validate.checkZip(a)));
            current.setAge(Integer.parseInt(ask("Életkor: ", "10 évesnél idősebb és 150 évesnél fiatalabbak olthatók csak be!",
                    a -> validate.checkAge(a))));
            current.setEmail(getEmail());
            current.setTaj(ask("TAJ szám: ", "Hibás TAJ szám",
                    a -> validate.checkTaj(a)));
        } catch (IllegalStateException e) {
            System.out.println("Adatbeviteli folyamat megszakítva. Visszalépés a főmenübe.");
            return;
        }
        try {
            logic.insertCitizen(current);
            System.out.println("Sikeres regisztráció.");
        } catch (IllegalStateException e) {
            System.out.println("Sikertelen regisztráció!");
        }
    }

    private String ask(String question, String errorMessage, Predicate<String> validator) {
        boolean invalidData;
        String answer;
        do {
            System.out.print(question);
            answer = scanner.nextLine().trim();
            invalidData = validator.test(answer);
            if (invalidData) {
                System.out.print("  " + errorMessage);
                doYouWantToContinue();
            } else if (question.equals(QUESTION_ZIP)) {
                System.out.println("Település: " + logic.getCity(answer));
            }
        } while (invalidData);
        return answer;
    }

    private String getEmail() {
        String emailFirst;
        String emailSecond;
        do {
            emailFirst = ask("E-mail cím: ", "Hibás e-mail cím!", a -> validate.checkEmail(a));
            emailSecond = ask("E-mail cím újra:", "", a -> false);
            if (!emailFirst.equals(emailSecond)) {
                System.out.println("Nem egyforma a megadott két e-mail cím!");
            }
        } while (!emailFirst.equals(emailSecond));
        return emailFirst;
    }

    private void doYouWantToContinue() {
        System.out.print(" Akarja folytatni? (i/n) ");
        if (scanner.nextLine().toLowerCase().startsWith("n")) {
            throw new IllegalStateException("Citizen has interrupted the registration.");
        }
    }


    private void registrationFromFile() {
        System.out.println("Addja meg a tömeges regisztrációs adatokat tartalmazó fájlt: ");
        String path = scanner.nextLine();

        List<String> invalidLines = new ArrayList<>();

        try {
            invalidLines = logic.registrationFromFile(path, invalidLines);
            if (invalidLines.isEmpty()) {
                System.out.println("Sikeres csoportos adat felöltés!");
            }
        } catch (IllegalStateException e) {
            if (e.getMessage().contains("Can't open the file!")) {
                System.out.println("\nNem lehetett megnyitni a filet: " + path);
            } else {
                printDataError(invalidLines);
            }
        }
    }

    private void printDataError(List<String> invalidLines) {
        System.out.println("\n Adatbázis hiba!");
        System.out.println("A hibás sorok:");
        for (String oneLine : invalidLines) {
            if (!oneLine.isBlank()) {
                System.out.println(oneLine);
            }
        }
    }


    private void generate() {
        System.out.println("Kérem az irányítószámot: ");
        String zip = scanner.nextLine();
        String city = logic.getCity(zip);
        if (city.isBlank()) {
            System.out.println("Nincs ilyen irányítószám!");
        }
        System.out.println(city);

        System.out.print("Kérem a fájl nevét: ");
        String path = scanner.nextLine();

        if (logic.generate(zip, path)) {
            System.out.println("Ide mentettem a listát: " + path);
        } else {
            System.out.println("Sikertelen generálás!");
        }
    }

    //Csak a tesztelés miatt public, élesben private
    public void vaccinate() {
        Vaccine vaccine = new Vaccine();
        try {
            setTaj(vaccine);

            setId(vaccine);
            if (vaccine.getId() < 0) {
                System.out.println("Ezzel a TAJ számmal nem regisztráltak!");
                return;
            }

            setNumberOfVaccinations(vaccine);
            if (vaccine.getNumberOfVaccinations() > 1) {
                System.out.println("Már megkapta mind a két oltását, nem kaphat több oltást!");
                return;
            }

            while (setVaccineDate(vaccine)) ;

            setSuccessfull(vaccine);

            setVaccineName(vaccine);

            setVaccineNote(vaccine);

            logic.storeVaccination(vaccine);

            System.out.println("Sikeresen eltároltuk az adatokat.");
        } catch (IllegalStateException e) {
            System.out.println("Adatbázis elérési hiba, nem lehet regisztrálni.");
        }
    }

    private void setTaj(Vaccine vaccine) {
        System.out.print("Kérem a taj számát: ");
        vaccine.setTaj(scanner.nextLine().trim());
    }

    private void setId(Vaccine vaccine) {
        vaccine.setId(logic.getIdByTaj(vaccine));
    }

    private void setNumberOfVaccinations(Vaccine vaccine) {
        vaccine.setNumberOfVaccinations(logic.getNumberOfVaccinationsById(vaccine));
    }

    private boolean setVaccineDate(Vaccine vaccine) {
        System.out.printf("Kérem a(z) %d. oltás dátumát!\n   év: ", vaccine.getNumberOfVaccinations() + 1);
        String value;
        do {
            value = scanner.nextLine();
        } while (!value.matches("[0-9]{4}"));
        int year = Integer.parseInt(value);

        System.out.print("hónap: ");
        do {
            value = scanner.nextLine();
        } while (!value.matches("[0-9]{1,2}"));
        int month = Integer.parseInt(value);

        System.out.print("  nap: ");
        do {
            value = scanner.nextLine();
        } while (!value.matches("[0-9]{1,2}"));
        int day = Integer.parseInt(value);

        try {
            vaccine.setDate(LocalDate.of(year, month, day));
            return false;
        } catch (DateTimeException e) {
            System.out.println("Hibás dátum!");
            return true;
        }

    }

    private void setSuccessfull(Vaccine vaccine) {
        System.out.println("Megengedte az oltás beadását? (i/n) ");
        if (scanner.nextLine().toLowerCase().startsWith("i")) {
            vaccine.setResult(Logic.SUCCESSFUL);
        } else {
            vaccine.setResult(Logic.FAILED);
        }
    }

    private void setVaccineName(Vaccine vaccine) {
        if (!vaccine.getResult().equals(Logic.SUCCESSFUL)) {
            return;
        }
        if (vaccine.getNumberOfVaccinations() > 0) {
            vaccine.setVaccine(logic.getVaccine(vaccine.getId()));
            System.out.println(vaccine.getVaccine() + " oltószert kapott.");
        } else {
            System.out.println("Kérem az oltószert: ");
            vaccine.setVaccine(scanner.nextLine().trim());
        }
    }

    private void setVaccineNote(Vaccine vaccine) {
        System.out.println("Megjegyzés: ");
        vaccine.setNote(scanner.nextLine().trim());
    }


    private void report() {
        List<String> report = logic.getReport();

        if (report.isEmpty()) {
            System.out.println("Elnézéts, nem sikerült a lekérdezés.");
        } else {
            for (String oneLine : report) {
                System.out.println(oneLine);
            }
        }
    }
}
//        Funkcionális leírás
//
//        Egy olyan valódi alkalmazást kell készítened, mely megszervezi az oltásokat. Az alkalmazás konzolos felülettel, és relációs adatbázissal rendelkezik (MariaDB).
//
//        Az üzleti folyamat a következő lépésekből áll:
//
//        Az állampolgár regisztrálja magát az oltásra. A következő adatokat kell megadnia:
//
//        Teljes név
//        Irányítószám
//        Életkor
//        E-mail cím
//        TAJ száma
//
//        Amikor regisztrálja magát, a következőket kell megvalósítani:
//
//        Ellenőrizzük, a név nem lehet üres
//        Ha beírja az irányítószámát, akkor írjuk ki a hozzá tartozó települést
//        Ha az irányítószám üres, hibaüzenetet kell kiírni
//        Az életkor > 10 és < 150.
//        Az e-mail cím legyen formaliag helyes, elegendő, ha legalább 3 karakter, és van benne egy @ karakter
//    Az e-mail címét kétszer kell megadni, és másodjára is ugyanazt a címet kell megadni
//            A TAJ számot CDV ellenőrzésnek kell alávetni
//
//            Az irányítószámokhoz tartozó települések megtalálhatóak ebben az állományban:
//
//            https://github.com/Training360/strukturavalto-java-public/blob/master/examples/week13d01/src/main/resources/iranyitoszamok-varosok-2021.csv
//
//            (Ezt importáld be egy táblába, HeidiSQL Tools/Import CSV fájl... menüpont felhasználásával!)
//
//            A CDV ellenőrzés algoritmusa:
//
//            A TAJ szám első nyolc számjegyéből a páratlan helyen állókat hárommal, a páros helyen állókat héttel szorozzuk, és a szorzatokat összeadjuk. Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz CDV kódnak.
//
//            A regisztrációkat tömegesen is be lehet adni egy CSV állományban. Erre azért van szükség, mert egy idősotthonban nem regisztrálja be mindenki saját magát, hanem egyszerre regisztrálják be őket, automatikusan.
//
//            A szöveges állomány a formátuma a következő (az első rész a fejléc):
//
//            Név;Irányítószám;Életkor;E-mail cím;TAJ szám
//            John Doe;2061;60;john.doe@example.com;1234567890
//        Jane Doe;2091;40;jane.doe@example.com;1234567881
//
//        Ilyen fájlt generálhatsz a következő címen:
//
//        https://mockaroo.com/
//
//        A második lépésként ki kell generálni irányítószámonként az oltások listáját egy fájlba. Mivel az idősebbek veszélyeztetettebbek, ezért életkor szerint kell a még nem beoltottakat sorba rendezni, utána pedig név szerint. Mivel óránként 2 ember tudnak csak beoltani, ezért az első 16 ember adatait kell csak kiírni. Valamint azokat kell csak behívni, akiknek még nem volt oltása, vagy volt oltása, azonban már eltelt 15 nap.
//
//        A fájl formátuma:
//
//        Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám
//        8:00;John Doe;2061;60;john.doe@example.com;1234567890
//        8:30;Jane Doe;2091;40;jane.doe@example.com;1234567881
//
//        Látható, hogy az időpontot is bele kell generálni. (8:00-tól 16:00-ig, félórás időközökkel)
//
//        A következő lépésben megtörténik az első oltás. Az oltás elvégzéséhez meg kell adni a TAJ számot, a dátumot és az oltóanyag típusát.
//
//        Ha a TAJ szám érvénytelen, vagy nincs rá regisztráció, hibaüzenetet kell kiírni.
//
//        Azonban az oltás meg is hiúsulhat. Pl. az állampolgár visszautasítja, olyan betegsége van, várandós, stb. Ezt is rögzíteni kell a rendszerben a TAJ szám, dátum és indoklás megadásával.
//
//        A következő lépésben megtörténik az második oltás. Ugyanazokat az adatokat kell megadni. Azonban itt arra is figyelni kell, hogy az előző oltás óta 15 napnak el kell telnie. Valamint ki kell írnia az előző oldás gyártóját, mert csak ugyanazzal lehet beoltani.
//
//        Az alkalmazásba kell egy riportot is megvalósítani, ami kiírja, hogy irányítószámonként hány beoltatlan, egyszer és kétszer beoltott állampolgár van.
//        Technológiai javaslatok
//        Adatbázis
//
//        Az adatbázissal kapcsolatban azt javaslom, hogy a regisztráció táblában legyen eltárolva, hogy hány vakcinát adtak be, és mikor volt az utolsó beadása. És ezt kell update-elni. Ekkor nem kell joinolni, egyszerűbbé válnak a lekérdezések.
//
//        Adatbázis terv
//        Felhasználói felület
//
//        Természetesen egy konzolos alkalmazást kell készíteni. Először legyen egy menü:
//
//        1. Regisztráció
//        2. Tömeges regisztráció
//        3. Generálás
//        4. Oltás
//        5. Oltás meghiúsulás
//        6. Riport
//
//        A menüpontok rendre:
//
//        Regisztráció: kérje be sorban az adatokat, ahol hiba van, azonnal jelezze ki. A regisztrációt vegye fel citizens táblába.
//        Tömeges regisztráció: kérje be a fájl elérési útvonalát, ha nincs ott, vagy hibás a fájl, akkor írjon ki hibaüzenetet, amúgy töltse be a citizens táblába
//        Generálás: kérje be az irányítószámot, majd a fájlt, amilyen néven el kell menteni
//        Oltás: be kell kérni a TAJ számot. Le kell kérdezni, hogy volt-e már oldása. Ha nem volt, akkor be kell kérni a dátumot és a típust. Ha már volt egy, akkor ki kell írni, hogy mikor és milyen vakcinával. Majd be kell írni a dátumot. Ha már kettő volt neki, akkor hibaüzenetet kell kiírni.
//        Oltás meghiúsulás: be kell írni a TAJ számot, majd a meghiúsulás okát.
