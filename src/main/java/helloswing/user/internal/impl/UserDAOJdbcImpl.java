package helloswing.user.internal.impl;

import java.util.Optional;

import helloswing.user.internal.User;
import helloswing.user.internal.UserDAO;

/**
 * JDBC implementation of the UserDAO interface. This class handles all the CRUD
 * operations related to the User entity.
 */
public class UserDAOJdbcImpl implements UserDAO {

    @Override
    public Optional<User> findByName(String name) {
	// TODO
	return null;
    }

    @Override
    public void save(User user) {
	// TODO
    }

    @Override
    public void update(User user) {
	// TODO
    }
}
