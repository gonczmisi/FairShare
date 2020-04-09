package hu.elte.fairshare.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.utils.UserRole;

/**
 * This class is used to test the REST functions of the User type.
 * 
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {

    /**
     * The controller reference used for testing.
     */
    @Autowired
    UserController userController;

    /**
     * Tests POST, GET and DELETE.
     */
    @Test
    public void newUser_CreatedAndRetrievedAndDeletedSuccesfully() {

        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);

        userController.post(user);
        User result = userController.getByUsername(user.getUsername()).getBody();

        assertEquals(user.getUsername(), result.getUsername());

        userController.delete(result.getId());
        result = userController.getByUsername(user.getUsername()).getBody();

        assertNull(result);
    }

    /**
     * Tests POST, GET, PUT and DELETE.
     */
    @Test
    public void existingUser_ModifiedAndRetrievedAndDeletedSuccesfully()
    {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);

        userController.post(user);
        User result = userController.getByUsername(user.getUsername()).getBody();

        assertEquals(user.getUsername(), result.getUsername());

        userController.putUsername(user, "MODIFIED");
        result = userController.getByUsername("MODIFIED").getBody();

        assertEquals("MODIFIED", result.getUsername());

        userController.delete(result.getUsername());
        result = userController.getByUsername(user.getUsername()).getBody();

        assertNull(result);
    }
}