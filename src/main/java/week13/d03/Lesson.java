package week13.d03;

public class Lesson {
    private String teacherName;
    private String subjectName;
    private String className;
    private int hour;

    public Lesson(String teacherName, String subjectName, String className, int hour) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.hour = hour;
    }

    public Lesson(String[] lesson) {
        teacherName = lesson[0];
        subjectName = lesson[1];
        className = lesson[2];
        if (lesson[3].matches("[0-9]+")) {
            hour = Integer.parseInt(lesson[3]);
        }
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public int getHour() {
        return hour;
    }
}
