package helloswing.user.internal;

import java.util.Objects;

/**
 * Represents a user with an ID, name, and visit count.
 */
public class User {
    private int id;
    private String name;
    private int visitCount;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor with name. Sets visitCount to 1.
     * 
     * @param name the user name
     */
    public User(String name) {
	this.name = name;
	this.visitCount = 1;
    }

    /**
     * Copy constructor.
     * 
     * @param other the user to copy
     */
    public User(User other) {
	this.id = other.id;
	this.name = other.name;
	this.visitCount = other.visitCount;
    }

    /**
     * Gets the user ID.
     * 
     * @return the ID
     */
    public int getId() {
	return id;
    }

    /**
     * Sets the user ID.
     * 
     * @param id the ID to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Gets the user name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the user name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the visit count.
     * 
     * @return the visit count
     */
    public int getVisitCount() {
	return visitCount;
    }

    /**
     * Sets the visit count.
     * 
     * @param visitCount the visit count to set
     */
    public void setVisitCount(int visitCount) {
	this.visitCount = visitCount;
    }

    /**
     * Increments the visit count by one.
     */
    public void incrementVisitCount() {
	this.visitCount++;
    }

    /**
     * Returns string representation of the user.
     * 
     * @return string with user data
     */
    @Override
    public String toString() {
	return "User{" + "id=" + id + ", name='" + name + '\'' + ", visitCount="
	    + visitCount + '}';
    }

    /**
     * Returns hash code based on ID.
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    /**
     * Checks equality based on ID.
     * 
     * @param obj the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	return id == other.id;
    }
}