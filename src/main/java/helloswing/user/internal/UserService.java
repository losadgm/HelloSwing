package helloswing.user.internal;

import java.util.Optional;

import helloswing.shared.GreetingDTO;

public class UserService {

    private final UserDAO userDAO;

    /**
     * Validation for user names.
     */
    private void validateName(String name) {
	if (name == null || name.trim()
				.isEmpty()) {
	    throw new IllegalArgumentException("Name cannot be empty");
	}

	if (name.trim()
		.length() > 50) {
	    throw new IllegalArgumentException(
		"Name is too long (max 50 characters)");
	}
    }

    /**
     * Dependency injection constructor
     * 
     * @param userDAO dependency
     */
    public UserService(UserDAO userDAO) {
	this.userDAO = userDAO;
    }

    /**
     * Handles the greeting of a user and the track of their visits.
     * 
     * @param name The name of the user to greet
     * @return GreetingDTO containing visit information and user data
     * @throws IllegalArgumentException if name is null, empty or longer than 50
     *                                  characters
     */
    public GreetingDTO greetUser(String name) {
	validateName(name);

	Optional<User> existingUser = userDAO.findByName(name);

	if (existingUser.isPresent()) {
	    return handleReturningUser(existingUser.get());
	}
	return handleNewUser(name);
    }

    /**
     * Takes a unique name and creates and saves a user.
     */
    private GreetingDTO handleNewUser(String name) {
	User newUser = new User(name); // visitCount = 1 by default
	userDAO.save(newUser);
	return new GreetingDTO(newUser, true); // true = isNewUser
    }

    /**
     * Increments visit count and updates the given user.
     */
    private GreetingDTO handleReturningUser(User user) {
	user.incrementVisitCount();
	userDAO.update(user);
	return new GreetingDTO(user, false); // false = not new user
    }
}
