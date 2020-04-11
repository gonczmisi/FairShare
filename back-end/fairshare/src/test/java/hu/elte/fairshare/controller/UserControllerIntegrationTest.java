package hu.elte.fairshare.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

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

    /**
     * Retrieves all user entites and checks if exists.
     */
    @Test
    public void retrieveAllUsers_Succesfully() {
        Iterable<User> result = userController.getAll().getBody();

        assertNotNull(result);
    }

    /**
     * Test the GET REST methods.
     */
    @Test
    public void retrieveUsersByAttributes_Succesfully() {
        User user;
        List<User> userList;

        // By id
        user = userController.getById(new Long(0)).getBody();
        assertEquals("user_by_id", user.getUsername());

        // By username
        user = userController.getByUsername("user_by_username").getBody();
        assertEquals("user_by_username", user.getUsername());

        // By email address
        user = userController.getByEmail("by@email.address").getBody();
        assertEquals("user_by_email_address", user.getUsername());

        // By role
        userList = userController.getByRole(UserRole.TEST).getBody();
        assertEquals(4, userList.size());
    }

    /**
     * Test the POST, PUT, DELETE methods.
     */
    @Test
    public void modifyUsersByAttributes_Succesfully() {
        User user;

        // By username
        user = userController.getByUsername("user_by_username").getBody();
        userController.putUsername(user, "UPDATED");
        user = userController.getByUsername("UPDATED").getBody();
        assertEquals("UPDATED", user.getUsername());
        userController.putUsername(user, "user_by_username");
        user = userController.getByUsername("user_by_username").getBody();
        assertEquals("user_by_username", user.getUsername());

        // By email address
        user = userController.getByEmail("by@email.address").getBody();
        userController.putEmail(user, "UPDATED@email.address");
        user = userController.getByEmail("UPDATED@email.address").getBody();
        assertEquals("user_by_email_address", user.getUsername());
        userController.putEmail(user, "by@email.address");
        user = userController.getByEmail("by@email.address").getBody();
        assertEquals("user_by_email_address", user.getUsername());

        // By role
        user = userController.getByUsername("user_by_role").getBody();
        userController.putRole(user, UserRole.GUEST);
        user = userController.getByUsername("user_by_role").getBody();
        assertEquals(UserRole.GUEST, user.getUserRole());
        userController.putRole(user, UserRole.TEST);
        user = userController.getByUsername("user_by_role").getBody();
        assertEquals(UserRole.TEST, user.getUserRole());
    }
}