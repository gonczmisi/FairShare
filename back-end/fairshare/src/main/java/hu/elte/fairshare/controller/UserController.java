package hu.elte.fairshare.controller;

import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.repository.UserRepository;
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
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
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
    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
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
     * The put method sets the id of the given user to the given id.
     * @param user The user we want to update.
     * @param userName The new username for the user.
     * @return The updated user instance.
     */
    @PutMapping("/{username}")
    public ResponseEntity<User> put(@RequestBody User user, @PathVariable String userName) {
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isPresent()) {
            user.setUsername(userName);
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
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}