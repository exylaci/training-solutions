package week03.d05;

import org.junit.jupiter.api.Test;
import week03.d05.Operation;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTeszt {

    @Test
    public void testGetResult(){

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Operation(null);
        });
        assertEquals("Wrong argument!", ex.getMessage());

         ex = assertThrows(IllegalArgumentException.class, () -> {
            new Operation("kkk");
        });
        assertEquals("Wrong argument!", ex.getMessage());

        assertEquals(7, new Operation("3+4").getResult());
    }
}