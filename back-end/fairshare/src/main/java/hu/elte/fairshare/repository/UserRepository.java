package hu.elte.fairshare.repository;

import hu.elte.fairshare.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * The UserRepository interface extends the CrudRepository interface and creates
 * a container for the users.
 * 
 * @author sajtizsolt
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
    /**
     * The findByUserName method is searching for the user by the given
     * username.
     * 
     * @param userName The username of the user being searched.
     * @return User The user with the given username.
     */
    Optional<User> findByUsername(String userName);
}