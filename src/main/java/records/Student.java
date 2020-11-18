package records;

import java.util.ArrayList;
import java.util.List;

public class Student {
    List<Mark> marks = new ArrayList<>();
    String name;

    public Student(String name) {
        if ( isEmpty(name) ){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name.trim();
    }

    public void grading(Mark mark){
        if ( mark==null ){
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }
    public double calculateAverage(){
        if ( marks.size()==0 ){
            return 0;
        }
        double sum = 0;
        int pieces = 0;
        for ( Mark one : marks ) {
            sum += one.getMarkType().value;
            ++pieces;
        }
        return Math.round( sum/pieces*100) / 100.;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0;
        int pieces = 0;
        for (Mark one : marks) {
            if( one.subject.getSubjectName().equals(subject.getSubjectName())){
                sum += one.getMarkType().value;
                ++pieces;
            }
        }
        if ( pieces==0 ) {
            return 0;
        }
        return Math.round(sum / pieces * 100) / 100.;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append( String.format("%s marks:",name) );
        for ( Mark one : marks ) {
            sb.append( String.format(" %s: %s",one.getSubject().getSubjectName(),one) );
        }
        return sb.toString();
        }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String string){
        return string==null || string.isBlank() ;
    }
}
