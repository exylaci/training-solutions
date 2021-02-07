package week14.d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Student {
    private String name;
    private Map<String, List<Integer>> marks = new TreeMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student student) {
        name = student.name;
        marks = new TreeMap<>(student.marks);
    }

    public void addMark(String subject, int mark) {
        if (!marks.containsKey(subject)) {
            marks.put(subject, new ArrayList<>());
        }
        marks.get(subject).add(mark);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + '{' + marks + '}';
    }
}
