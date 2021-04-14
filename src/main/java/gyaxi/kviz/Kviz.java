package gyaxi.kviz;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Kviz {
    public static final long AVAILABLE_MINUTES = 60;
    public static final int PIECES_QUESTIONS_TO_ANSWER = 25;

    private Dao dao;
    private int pieces;
    private List<Integer> asked = new ArrayList<>();

    private boolean init() {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            source.setUser("employees");
            source.setPassword("employees");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
        }
        dao = new Dao(source);
        pieces = dao.getPieces();
        return pieces > 0;
    }

    private void asking() {
        LocalTime time = LocalTime.now();
        long usedMinutes = 0;
        int correct = 0;
        do {
            Question question = getAQuestion();
            asked.add(question.getId());
            writeQuestion(question);
            int answer = getAnswer();
            if (answer == 0) {
                break;
            }
            if (question.getAnswers().get(answer - 1).startsWith("@")) {
                ++correct;
                System.out.print("\nJó válasz. :)");
            } else {
                System.out.print("\nRossz válasz. :(");

            }
            usedMinutes = ChronoUnit.MINUTES.between(time, LocalTime.now());
            System.out.printf("  Eddig %d válaszból %d helyes. Ez %d%%-os eredményt jelent.  Hátralévő idő: %d perc.%n",
                    asked.size(), correct, 100 * correct / asked.size(), AVAILABLE_MINUTES - usedMinutes);
        } while (asked.size() < pieces && asked.size() < PIECES_QUESTIONS_TO_ANSWER && usedMinutes < AVAILABLE_MINUTES);

        if (usedMinutes >= AVAILABLE_MINUTES) {
            System.out.println("\nLejárt az idő.");
        }
    }

    private void writeQuestion(Question question) {
        System.out.printf("%n%d. kérdés: %s%n", asked.size(), question.getQuestion().replace("\n", "\n\t\t\t"));
        int numero = 0;
        for (String one : question.getAnswers()) {
            if (one.startsWith("@")) {
                System.out.printf("\t%d: %s%n", ++numero, one.substring(1));
            } else {
                System.out.printf("\t%d: %s%n", ++numero, one);
            }
        }
    }

    private Question getAQuestion() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(pieces) + 1;
        } while (asked.contains(id));
        return dao.getQuestion(id);
    }

    private int getAnswer() {
        String selected;
        do {
            System.out.print("(Kilépés: k) Válasz (1-4): ");

            selected = new Scanner(System.in).nextLine();
            if (selected.matches("[1-4]+")) {
                return Integer.parseInt(selected);
            }

        } while (!selected.toUpperCase().startsWith("K"));
        return 0;
    }

    public static void main(String[] args) {
        Kviz kviz = new Kviz();
        if (kviz.init()) {
            System.out.print("Jöhet a 25 kérdés? (igen/nem): ");
            if (!new Scanner(System.in).nextLine().toUpperCase().startsWith("I")) {
                return;
            }
            kviz.asking();
        } else {
            System.out.println("Üres a kérdések adatbázis!");
        }
    }
}