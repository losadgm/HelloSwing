package helloswing.user.internal;

import java.util.Optional;

/**
 * Interface for Data Access Object for the User entity. Defines CRUD operations
 * to be performed on the User model.
 */
public interface UserDAO {

    /**
     * Finds a user by their name.
     * 
     * @param name The name of the user to find.
     * @return an Optional containing the user if found, otherwise an empty
     *         Optional.
     */
    Optional<User> findByName(String name);

    /**
     * Saves a new user to the database. The user name must be unique. The id
     * will be ignored and automatically incremented.
     * 
     * @param user The user object to save.
     * @throws IllegalStateException when the user name is not unique
     */
    void save(User user);

    /**
     * Updates an existing user's data in the database. The visit count will be
     * updated. The user name will not be changed.
     * 
     * @param user The user object with updated information.
     */
    void update(User user);
}
