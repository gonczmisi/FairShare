package hu.elte.fairshare.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.elte.fairshare.entities.User;

/**
 * This class tests the AuthenticatedUser type.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticatedUserTest {

    /**
     * Tests the basic funcitons.
     */
    @Test
    public void modifyUser_Succesfully() {
        AuthenticatedUser authenticatedUser = new AuthenticatedUser();
        User user1 = new User();
        user1.setUsername("original");
        User user2 = new User();
        user2.setUsername("updated");
        
        authenticatedUser.setUser(user1);
        assertEquals("original", authenticatedUser.getUser().getUsername());
        assertEquals(user1, authenticatedUser.getUser());

        authenticatedUser.setUser(user2);
        assertEquals("updated", authenticatedUser.getUser().getUsername());
        assertEquals(user2, authenticatedUser.getUser());
    }
}