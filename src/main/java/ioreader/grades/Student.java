package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(marks);
    }

    public String getName() {
        return name;
    }

    public double average() {
        int sum = 0;
        for (Integer one : marks) {
            sum += one;
        }
        return (double) sum / Math.max(marks.size(), 1);
    }

    public boolean isIncreasing() {
        if (marks.size() < 2) return true;
        for (int i = 1; i < marks.size(); ++i) {
            if (marks.get(i - 1) > marks.get(i)) {
                return false;
            }
        }
        return true;
    }
}