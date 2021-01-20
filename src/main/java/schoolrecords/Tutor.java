package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    String name;
    List<Subject> taughtSubject = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubject) {
        if ( name==null || name.isBlank() || taughtSubject==null || taughtSubject.size()==0 ){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public boolean tutorTeachingSubject(Subject subject){
        if ( subject==null ){
            throw new NullPointerException("Subject must be provided!");
        }
        for ( Subject one : taughtSubject ) {
            if ( one.getSubjectName().equals(subject.getSubjectName() )){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
