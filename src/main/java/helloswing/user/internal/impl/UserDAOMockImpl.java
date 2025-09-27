package helloswing.user.internal.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import helloswing.shared.Utils;
import helloswing.user.internal.User;
import helloswing.user.internal.UserDAO;

/**
 * Non persistent mock implementation of the UserDAO interface. This class
 * handles all the CRUD operations related to the User entity.
 */
public class UserDAOMockImpl implements UserDAO {

    private Map<String, User> userMap = new ConcurrentHashMap<String, User>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    private void checkUniqueUser(User user) {
	if (userMap.containsKey(user.getName())) {
	    throw new IllegalStateException(
		"User with name '" + user.getName() + "' already exists.");
	}
    }

    @Override
    public Optional<User> findByName(String name) {
	Utils.checkNullArgs(name);
	User userData = userMap.get(name);
	return Optional.ofNullable(
	    userData != null ? new User(userData) : null);
    }

    @Override
    public void save(User user) {
	Utils.checkNullArgs(user);
	checkUniqueUser(user);
	User userData = new User(user);
	userData.setId(idGenerator.getAndIncrement());
	userMap.put(userData.getName(), userData);
    }

    @Override
    public void update(User user) {
	Utils.checkNullArgs(user);
	User userData = userMap.get(user.getName());
	userData.setVisitCount(user.getVisitCount());
    }

}
