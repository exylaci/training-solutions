package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    String className;
    Random rnd = new Random();
    List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }


    public boolean addStudent(Student student) throws IllegalArgumentException {
        checkEmpty(student);
        for ( Student one : students ) {
            if ( one.getName().equals(student.getName()) ){
                return false;
            }
        }
        return students.add(student);
    }

    public boolean removeStudent(Student student) throws IllegalArgumentException {
        checkEmpty(student);
        for ( int i=0 ; i<students.size() ; ++i ){
            if( students.get(i).getName().equals(student.getName()) ){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage(){
        if ( students.size()==0 ){
            throw  new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum=0;
        int counter=0;
        double average;
        for ( Student one : students ) {
            average = one.calculateAverage();
            if ( average!=0 ){
                sum += average;
                ++counter;
            }
        }
        if ( counter==0 ){
            throw  new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round( sum/counter*100)/100.;
    }

    public double calculateClassAverageBySubject(Subject subject){
        if ( students.size()==0 ){
            throw  new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum=0;
        int counter=0;
        double average;
        for ( Student one : students ) {
            average = one.calculateSubjectAverage(subject);
            if ( average!=0 ){
                sum += average;
                ++counter;
            }
        }
        if ( counter==0 ){
            throw  new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round( sum/counter*100)/100.;
    }

    public Student findStudentByName(String name){
        if ( isEmpty(name) ){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if ( students.size()==0 ){
            throw new IllegalStateException("No students to search!");
        }
        for ( Student one : students ) {
            if ( one.getName().equals(name) ){
                return one;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! "+name);
    }

    public Student repetition(){
        if ( students.size()==0 ){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get( rnd.nextInt(students.size()) );
    }

    public List<StudyResultByName> listStudyResults(){
        if ( students.size()==0 ){
            throw new IllegalStateException("No students for listing!");
        }

        List<StudyResultByName> result = new ArrayList<>();
        for ( Student one : students ) {
            result.add( new StudyResultByName( one.name, one.calculateAverage() ));
        }
        return result;
    }

    public String listStudentNames(){
        if ( students.size()==0 ){
            throw new IllegalStateException("No students for listing!");
        }

        StringBuilder sb = new StringBuilder();
        for ( Student one : students ) {
            sb.append( one.name );
            sb.append(", ");
        }
        return sb.substring(0,sb.length()-2).toString();
    }

    public String getClassName() {
        return className;
    }

    private void checkEmpty(Student student){
        if ( student==null ){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
    }
    private boolean isEmpty(String string){
        return string==null || string.isBlank() ;
    }

}
