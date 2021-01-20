package schoolrecords;

public class Subject {
    String subjectName;

    public Subject(String subjectName) {
        if ( subjectName==null || subjectName.isBlank() ){
            throw new NullPointerException("Subject name must not be empty!");
        }
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
