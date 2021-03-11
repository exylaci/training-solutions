package erettsegik.oktober2020.sorozatok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private List<Episode> episodes = new ArrayList<>();
    private Scanner scanner;

    public Main(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Episode> getEpisodes() {
        return Collections.unmodifiableList(episodes);
    }

    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));

        try {
            main.feladat1();
            main.feladat2();
            main.feladat3();
            main.feladat4();
            main.feladat5();
            main.feladat6();
            main.feladat7();
            main.feladat8();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    public void feladat1() {
        System.out.println("\n1. feladat");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("lista.txt")))) {

            String[] lines = new String[5];
            int line = 0;
            while ((lines[line] = reader.readLine()) != null) {
                ++line;
                if (line == 5) {
                    episodes.add(new Episode(lines));
                    line = 0;
                }
            }
            System.out.println("\tA feljegyzések belovasása megtörtént.");

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from notes file!");
        }
    }


    public void feladat2() {
        System.out.println("\n2. feladat");

        long pieces = episodes
                .stream()
                .filter(this::knownOnAirDate)
                .count();

        System.out.printf("\tA listában %d db vetítési dátummal rendelkező epizód van.%n", pieces);
    }

    private boolean knownOnAirDate(Episode episode) {
        return episode.getOnAirDate() != null;
    }


    public void feladat3() {
        System.out.println("\n3. feladat");

        double seen = episodes
                .stream()
                .filter(Episode::isSeen)
                .count();

        System.out.printf("\tA listában lévő epizódok %5.2f%%-át látta.%n", seen / episodes.size() * 100);
    }


    public void feladat4() {
        System.out.println("\n4. feladat");

        long sum = episodes
                .stream()
                .filter(Episode::isSeen)
                .mapToInt(Episode::getLength)
                .sum();

        System.out.printf("\tSorozatnézéssel %d napot %d órát és %d percet töltött.%n",
                sum / 60 / 24,
                sum % (60 * 24) / 60,
                sum % 60);
    }


    public void feladat5() {
        System.out.println("\n5. feladat");

        LocalDate limit = askDate();
        if (limit == null) return;

        printNitSeenEpisodes(limit);
    }

    private LocalDate askDate() {
        System.out.print("\tKérek egy dátumot éééé.hh.nn formában: ");
        String value = scanner.nextLine();

        if (value.matches("[0-9]{4}\\.[0-9]{1,2}\\.[0-9]{1,2}")) {
            return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy.M.d"));
        }
        System.out.println("\tHibás dátum!\n");
        return null;
    }

    private void printNitSeenEpisodes(LocalDate limit) {
        System.out.println("\tEzeket az epizódokat nem látta még:");

        for (Episode episode : episodes) {
            if (!episode.isSeen() && episode.getOnAirDate() != null && !episode.getOnAirDate().isAfter(limit)) {
                System.out.printf("\t%5s\t%s%n", episode.getEpisode(), episode.getTitle());
            }
        }
    }

    private void feladat6() {
    }

    private String hetnapja(int ev, int ho, int nap) {
        String[] napok = new String[]{"v", "h", "k", "sze", "cs", "p", "szo"};
        int[] honapok = new int[]{0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        if (ho < 3) {
            --ev;
        }
        return napok[(ev + ev / 4 - ev / 100 + ev / 400 + honapok[ho - 1] + nap) % 7];
    }


    public void feladat7() {
        System.out.println("\n7. feladat");

        String day = askDay();
        Set<String> titles = collectTtles(day);
        printEpisodes(titles);
    }

    private String askDay() {
        System.out.print("\tKérek egy napot (v,h,k,sze,cs,p,szo): ");
        String day = scanner.nextLine().toLowerCase();
        return day;
    }

    private Set<String> collectTtles(String day) {
        Set<String> titles = new HashSet<>();
        for (Episode episode : episodes) {
            if (episode.getOnAirDate() != null && day.equals(hetnapja(
                    episode.getOnAirDate().getYear(),
                    episode.getOnAirDate().getMonthValue(),
                    episode.getOnAirDate().getDayOfMonth()))) {
                titles.add(episode.getTitle());
            }
        }
        return titles;
    }

    private void printEpisodes(Set<String> titles) {
        if (titles.size() > 0) {
            System.out.println("\tEzen a napont ezeket a sorozatokat adják:");
            for (String title : titles) {
                System.out.printf("\t%s%n", title);
            }
        } else {
            System.out.println("\tA megadott napon nem kerül adásba sorozat.");
        }
    }


    private void feladat8() {
        System.out.println("\n8. feladat");


        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of("C:/temp/summa.txt"), StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

            wrtieLines(writer);
            System.out.println("\tAz összesítő kiírása megtörtént.");

        } catch (IOException e) {
            throw new IllegalStateException("Can't write summa.txt file!");
        }
    }

    public void wrtieLines(BufferedWriter writer) throws IOException {
        int length = 0;
        int pieces = 0;
        String title = episodes.get(0).getTitle();

        for (Episode episode : episodes) {
            if (!episode.getTitle().equals(title)) {
                writer.write(title + " " + length + " " + pieces);
                writer.newLine();
                length = 0;
                pieces = 0;
                title = episode.getTitle();
            }
            length += episode.getLength();
            ++pieces;
        }
    }

}
