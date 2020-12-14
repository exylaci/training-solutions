package week08.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    @Test
    public void robotTest(){
        Robot r = new Robot();

        Position p = r.move("JJBBBFFLLLL");
        assertEquals(-1,p.getX());
        assertEquals(-2,p.getY());
    }
}
