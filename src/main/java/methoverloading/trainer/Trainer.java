package methoverloading.trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int age;
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public void addCourse(String course){
        courses.add(new Course( course ));
    }


    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
