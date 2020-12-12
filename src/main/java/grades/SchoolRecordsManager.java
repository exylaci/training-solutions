package grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    public static final String SEPARATOR = " ";

    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        Path path = Path.of("src/main/resources").resolve(fileName);
        students.clear();
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                students.add(parseToStudent(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read this file!");
        }
    }

    private Student parseToStudent(String oneLine) {
        String[] split = oneLine.split(SEPARATOR);
        List<Integer> marks = new ArrayList<>();
        for (int i = 1; i < split.length; ++i) {
            marks.add(parse(split[i]));
        }
        return new Student(split[0], marks);
    }

    private Integer parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("This file is corrupt!", e);
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student one : students) {
            sum += one.average();
        }
        return sum / Math.max(students.size(), 1);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
//Osztálynapló
//
//A követező feladat egy osztálynapló nyilvántartása.
// A grades.txt fájl minden sora tartalmaz egy nevet és utána a tanuló jegyeit.
// Készíts egy Student osztályt mely a tanuló nevét és jegyeinek listáját képes tárolni!
// Legyen benne egy átlagszámító metódus, valamint egy metódus, ami képes eldönteni, hogy a tanuló jegyei emelkednek-e.
//
//Készíts egy SchoolRecordsManager osztályt, ami
// beolvassa fájlból az adatokat, eltárolja, és ezen felül még
// képes egy osztályátlag számítására is!