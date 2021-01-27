package week13.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Lesson> schedule = new ArrayList<>();

    public List<Lesson> getSchedule() {
        return schedule;
    }

    public void loadScheduleFromFile(Path path) {
        if (path == null) throw new IllegalArgumentException("Path is a must!");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            loadSchedule(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from: " + path);
        }
    }

    private void loadSchedule(BufferedReader reader) throws IOException {
        String[] lines = new String[4];
        for (int i = 0; (lines[i] = reader.readLine()) != null; ++i) {
            if (i == 3) {
                schedule.add(new Lesson(lines));
                i = -1;
            }
        }
    }

    public int summarisingTheWorkedHours(String teacherName) {
        return schedule
                .stream()
                .filter(a -> a.getTeacherName().equals(teacherName))
                .mapToInt(Lesson::getHour)
                .sum();
    }
}
//Adott a következő szerkezetű fájl, beosztas.txt:
//
//Albatrosz Aladin
//biologia
//9.a
//2
//Albatrosz Aladin
//osztalyfonoki
//9.a
//1
//Csincsilla Csilla
//matematika
//9.b
//2
//
//A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg. Első sor a
// tanár neve, majd a
// tantárgy, majd az
// osztály ahol tanítja és végül az, hogy
// heti hány órában.
//
//Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.