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

    public Lesson(String teacherName, String subjectName, String className, String hour) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.hour = Integer.parseInt(hour);
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
