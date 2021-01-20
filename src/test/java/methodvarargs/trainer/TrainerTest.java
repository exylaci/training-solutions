package methodvarargs.trainer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    void addCoursesTest(){
        Trainer t = new Trainer();
        t.addCourses("C#","java");
        assertEquals(2,t.getCourses().size() );

        String[] names = {"C++","pascal"};
        t.addCourses("python", names);
        assertEquals(5,t.getCourses().size() );
    }
}
