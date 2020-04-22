package hu.elte.fairshare.repository;

import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.utils.UserRole;
import java.util.List;
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

    /**
     * The findByEmailAddress method is searching for the user by the given
     * email address.
     *
     * @param emailAddress  The email address of the user being searched.
     * @return User The user with the given email address.
     */
    Optional<User> findByEmailAddress(String emailAddress);

    /**
     * The findByType method is searching for the users by the given
     * type.
     *
     * @param userRole  The role of the users being searched.
     * @return The users with the given type.
     */
    Optional<List<User>> findByUserRole(UserRole userRole);
}
