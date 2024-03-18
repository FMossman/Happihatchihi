import java.util.ArrayList;

/**
 * The UserManager class manages a collection of User objects.
 * It provides methods to add, remove, and retrieve users, as well as check if a user exists and if a password matches a given username.
 */
public class UserManager {

    private ArrayList<User> users;

    /**
     * Constructs a new UserManager object with an empty list of users.
     */
    public UserManager() {
        users = new ArrayList<User>();
    }

    /**
     * Adds a user to the list of users.
     * @param user The user to be added.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Removes a user from the list of users.
     * @param user The user to be removed.
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Retrieves a user with the specified username.
     * @param username The username of the user to retrieve.
     * @return The user with the specified username, or null if no such user exists.
     */
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Checks if a user with the specified username exists.
     * @param username The username to check.
     * @return true if a user with the specified username exists, false otherwise.
     */
    public boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a password matches the given username.
     * @param username The username to check.
     * @param password The password to check.
     * @return true if the password matches the given username, false otherwise.
     */
    public boolean passwordMatches(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a new user with the provided username and password.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The newly created User object.
     */
    public User createUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }
}

