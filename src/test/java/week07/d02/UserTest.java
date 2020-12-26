package week07.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    @Test
    public void interfaceTest() {
        User user1 = User.of("UserName", "First", "Last");
        assertEquals("UserName", user1.getUsername());
        assertEquals("First", user1.getFirstName());
        assertEquals("Last", user1.getLastName());
        assertEquals("First Last", user1.getFullName());
        assertTrue(user1 instanceof User);
        assertFalse(user1 instanceof UserImpl);

        User user2 = User.of2("UserName", "First", "Last");
        assertEquals("UserName", user2.getUsername());
        assertEquals("First", user2.getFirstName());
        assertEquals("Last", user2.getLastName());
        assertTrue(user2 instanceof User);
        assertTrue(user2 instanceof UserImpl);
    }

    @Test
    public void userImplTest() {
        User user = new UserImpl("UserName", "First", "Last");
        assertEquals("UserName", user.getUsername());
        assertEquals("First", user.getFirstName());
        assertEquals("Last", user.getLastName());
        assertTrue(user instanceof User);
        assertTrue(user instanceof UserImpl);
    }
}