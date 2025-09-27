package helloswing.shared;

import helloswing.user.internal.User;

/**
 * Data transfer object that encapsulates the outcome of a greeting operation.
 * Contains structured data that the presentation layer can use to format
 * messages.
 */
public class GreetingDTO {

    private final User user;
    private final boolean isNewUser;
    private final int visitCount;

    public GreetingDTO(User user, boolean isNewUser) {
	this.user = user;
	this.isNewUser = isNewUser;
	this.visitCount = user.getVisitCount();
    }

    public User getUser() {
	return user;
    }

    public boolean isNewUser() {
	return isNewUser;
    }

    public boolean isReturningUser() {
	return !isNewUser;
    }

    public int getVisitCount() {
	return visitCount;
    }

    public String getUserName() {
	return user.getName();
    }
}
