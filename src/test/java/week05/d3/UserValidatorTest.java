package week05.d3;

import org.junit.jupiter.api.Test;
import week03.Operation;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    @Test
    void validateTest(){
        UserValidator userValidator = new UserValidator();

        Exception exception = assertThrows( IllegalArgumentException.class, () ->
                userValidator.validate(Arrays.asList( new User(null,1)))
        );
        assertEquals("Name cannot be empty!", exception.getMessage());

        exception = assertThrows( IllegalArgumentException.class, () ->
                userValidator.validate(Arrays.asList( new User("",1)))
        );
        assertEquals("Name cannot be empty!", exception.getMessage());

        exception = assertThrows( IllegalArgumentException.class, () ->
                userValidator.validate(Arrays.asList( new User("Gábor áron",-1)))
        );
        assertEquals("Age must be between 0 and 120!", exception.getMessage());

        exception = assertThrows( IllegalArgumentException.class, () ->
                userValidator.validate(Arrays.asList( new User("Gábor áron",121)))
        );
        assertEquals("Age must be between 0 and 120!", exception.getMessage());

        assertTrue( userValidator.validate( Arrays.asList(
                new User( "Gábor Áron",36),
                new User("Kis Ernő",28)
        )));
    }
}
