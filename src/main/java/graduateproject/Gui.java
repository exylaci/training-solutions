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

    private String ask(String question, String errorMessage, Predicate<String> predicate) {
        boolean invalidData;
        String answer;
        do {
            System.out.print(question);
            answer = scanner.nextLine().trim();
            invalidData = predicate.test(answer);
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


    private void vaccinate() {
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

