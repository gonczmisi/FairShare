package hu.elte.fairshare.controller;

import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.repository.UserRepository;
import hu.elte.fairshare.utils.UserRole;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The UserController class implements a REST controller which can handle
 * get, post, put, delete requests.
 * 
 * @author sajtizsolt
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    /**
     * The repository instance of the controller.
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * The getAll method returns all of the data from the table.
     * @return All data from the users table.
     */
    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    
    /**
     * The get method returns the user with the given id.
     * @param id The id of the user.
     * @return The user with the given id.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The get method returns the user with the given username.
     * @param userName The username of the user.
     * @return The user with the given username.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> get(@PathVariable String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
    
        /**
     * The get method returns the user with the given username.
     * @param userName The username of the user.
     * @return The user with the given username.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmailAddress(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The get method returns the users with the given role.
     * @param role  The role of the users.
     * @return The users with the given role.
     */
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getByRole(@PathVariable UserRole role) {
        Optional<List<User>> users = userRepository.findByUserRole(role);
        if (users.isPresent()) {
            return ResponseEntity.ok(users.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The post method puts a new record into the table.
     * @param user The user we want to add to the table.
     * @return The new user instance.
     */
    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }
    
    /**
     * The put method sets the username of the given user
     * to the given username.
     * @param user The user we want to update.
     * @param userName The new username for the user.
     * @return The updated user instance.
     */
    @PutMapping("/username/{username}")
    public ResponseEntity<User> put(@RequestBody User user, @PathVariable String userName) {
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isPresent()) {
            user.setUsername(userName);
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The put method sets the email address of the given user
     * to the given email address.
     * @param user The user we want to update.
     * @param email  The new email address for the user.
     * @return The updated user instance.
     */
    @PutMapping("/email/{email}")
    public ResponseEntity<User> putEmail(@RequestBody User user, @PathVariable String email) {
        Optional<User> optionalUser = userRepository.findByEmailAddress(email);
        if (optionalUser.isPresent()) {
            user.setEmailAddress(email);
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The put method sets the role of the given user
     * to the given role.
     * @param user The user we want to update.
     * @param role  The new role for the user.
     * @return The updated user instance.
     */
    @PutMapping("/role/{role}")
    public ResponseEntity<User> putRole(@RequestBody User user, @PathVariable UserRole role) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            user.setUserRole(role);
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The delete method deletes a user from the table given by id.
     * @param id The id of the user.
     * @return The deleted user instance.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}