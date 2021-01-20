package methoverloading.trainer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {
    @Test
    public void addCoursesTest(){
        Trainer trainer = new Trainer("oktató",23);
        trainer.addCourse("Course1");
        trainer.addCourse(new Course("Course2"));

        assertEquals("Course1", trainer.getCourses().get(0).getName());
        assertEquals("Course2", trainer.getCourses().get(1).getName());
    }
}
