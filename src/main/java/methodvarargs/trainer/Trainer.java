package methodvarargs.trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<String> courses = new ArrayList<>();

    public void addCourses(String one, String... more){
        courses.add(one);
        for ( String course : more ) {
            courses.add(course);
        }
    }

    public List<String> getCourses(){
        return courses;
    }
}
