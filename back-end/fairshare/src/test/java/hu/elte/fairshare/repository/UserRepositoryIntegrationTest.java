package hu.elte.fairshare.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.utils.UserRole;

/**
 * This class tests the UserRepository classes functions, along with the
 * Item types basic functions.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

    /**
     * The repository instance used for testing.
     */
    @Autowired
    UserRepository userRepository;
    
    /**
     * This test checks if the repository can create a new item and save it into
     * the database, and also deletes it.
     * @throws Exception
     */
    @Test
    public void newUser_SavedSuccesfullyAndDeleteSuccesfulById() throws Exception {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);
        
        userRepository.save(user);
        Optional<User> result = userRepository.findById(user.getId());
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());

        userRepository.delete(user);
        result = userRepository.findById(user.getId());
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the repository can create a new item and save it into
     * the database, and also deletes it.
     * @throws Exception
     */
    @Test
    public void newUser_SavedSuccesfullyAndDeleteSuccesfulByUsername() throws Exception {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);
        
        userRepository.save(user);
        Optional<User> result = userRepository.findByUsername("test_username");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());

        userRepository.delete(user);
        result = userRepository.findByUsername("test_username");
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the created User entity has the appropiate values,
     * and also deletes the item.
     * @throws Exception
     */
    @Test
    public void newUser_ValuesAreRightAndDeleteSuccesfulByUsername() throws Exception {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);
        
        
        userRepository.save(user);
        Optional<User> result = userRepository.findByUsername("test_username");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_username", result.get().getUsername());
        assertEquals("test_password", result.get().getPassword());
        assertEquals("test_mail@domain.ext", result.get().getEmailAddress());
        assertEquals(UserRole.TEST, result.get().getUserRole());

        userRepository.delete(user);
        result = userRepository.findByUsername("test_item_values");
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the created User entity has the appropiate values,
     * and also deletes the item.
     * @throws Exception
     */
    @Test
    public void newUser_ValuesAreRightAndDeleteSuccesfulByEmailAddress() throws Exception {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);
        
        
        userRepository.save(user);
        Optional<User> result = userRepository.findByEmailAddress("test_mail@domain.ext");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_username", result.get().getUsername());
        assertEquals("test_password", result.get().getPassword());
        assertEquals("test_mail@domain.ext", result.get().getEmailAddress());
        assertEquals(UserRole.TEST, result.get().getUserRole());

        userRepository.delete(user);
        result = userRepository.findByEmailAddress("test_mail@domain.ext");
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the created User entity has the appropiate values,
     * and also deletes the item.
     * @throws Exception
     */
    @Test
    public void newUser_ValuesAreRightAndDeleteSuccesfulByUserRole() throws Exception {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmailAddress("test_mail@domain.ext");
        user.setUserRole(UserRole.TEST);
        
        
        userRepository.save(user);
        Optional<List<User>> result = userRepository.findByUserRole(UserRole.TEST);
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_username", result.get().get(0).getUsername());
        assertEquals("test_password", result.get().get(0).getPassword());
        assertEquals("test_mail@domain.ext", result.get().get(0).getEmailAddress());
        assertEquals(UserRole.TEST, result.get().get(0).getUserRole());

        userRepository.delete(user);
        result = userRepository.findByUserRole(UserRole.TEST);
        
        assertFalse(result.isPresent());
    }
}