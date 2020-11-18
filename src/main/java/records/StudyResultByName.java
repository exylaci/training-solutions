package records;

public class StudyResultByName {
    String studentName;
    double studyAverage;

    public StudyResultByName(String studentName, double studyAverage) {
        if ( studentName==null || studentName.isBlank() ){
            throw new NullPointerException("Student name must not be empty!");
        }
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }

    @Override
    public String toString() {
        return String.format("%s: %4.2f",studentName,studyAverage);
    }
}
