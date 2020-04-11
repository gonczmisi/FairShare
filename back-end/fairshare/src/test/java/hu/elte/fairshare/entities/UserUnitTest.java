package hu.elte.fairshare.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import hu.elte.fairshare.utils.UserRole;

/**
 * This class tests the User types' basic functions.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUnitTest {

    /**
     * Tests the basic getters and setters.
     */
    @Test
    public void newUser_GettersAndSettersAreRight() {
        User user = new User();
        user.setUsername("uname");
        user.setPassword("pw");
        user.setEmailAddress("a@b.c");
        user.setUserRole(UserRole.GUEST);

        assertEquals("uname", user.getUsername());
        assertEquals("pw", user.getPassword());
        assertEquals("a@b.c", user.getEmailAddress());
        assertEquals(UserRole.GUEST, user.getUserRole());
    }

    /**
     * Tests the equals and hashCode methods.
     */
    @Test
    public void newUsers_EqualsAndHashCodeAreRight() {
        User user1 = new User();
        user1.setUsername("USER");
        user1.setPassword("pw");
        user1.setEmailAddress("a@b.c");
        user1.setUserRole(UserRole.GUEST);

        User user2 = new User();
        user2.setUsername("USER");
        user2.setPassword("pw");
        user2.setEmailAddress("a@b.c");
        user2.setUserRole(UserRole.GUEST);

        assertTrue(user1.equals(user2));
        assertTrue(user2.equals(user1));
        assertEquals(user1.hashCode(), user2.hashCode());
    }
}