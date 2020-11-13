package week03;

import employee.Employee;
import org.junit.jupiter.api.Test;
import stringmethods.filename.FileNameManipulator;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTeszt {


    @Test
    public void testGetResult(){
        Operation operation = new Operation("3+4");

        assertEquals(7, operation.getResoult());
    }




}
