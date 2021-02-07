package week14.d03;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class ClassNotebook {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String student) {
        students.add(new Student(student));
    }

    public void addMark(String student, String subject, int mark) {
        for (Student oneStudent : students) {
            if (oneStudent.getName().equals(student)) {
                oneStudent.addMark(subject, mark);
                return;
            }
        }
        throw new IllegalArgumentException("Can't find student: " + student);
    }

    public List<Student> sortNotebook() {
//        List<Student> result = new ArrayList<>(students);
//        result.sort(Comparator.comparing(Student::getName, Collator.getInstance(new Locale("hu", "HU"))));
//        return result;

        return students
                .stream()
                .map(Student::new)
                .sorted(Comparator.comparing(Student::getName, Collator.getInstance(new Locale("hu", "HU"))))
                .collect(Collectors.toList());
    }

}
//Készíts egy diák (`Student`) osztályt melyben egy diák jegyeit tárolod egy Map-ben. A map kulcsa a tantárgy, értéke
// pedig az adott tantárgy jegyeinek listája. Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg. Legyen
// benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
// Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található. Készíts egy lekérdező metódust a
// `ClassNoteBook` osztályban, legyen a neve `sortNotebook` mely a diákok listáját ABC sorrendben adja vissza.