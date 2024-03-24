package com.example.happihatchihi.backend;

import com.example.happihatchihi.backend.User;

import java.util.HashMap;
import java.util.Map;

/**
 * The com.example.happihatchihi.backend.UserManager class manages a collection of User objects.
 * It provides methods to add, remove, and retrieve users, as well as check if a user exists and if a password matches a given username.
 */
public class UserManager {

    private Map<String, User> users;

    /**
     * Constructs a new com.example.happihatchihi.backend.UserManager object with an empty list of users.
     */
    public UserManager() {
        users = new HashMap<>();
    }

    /**
     * Adds a user to the collection of users.
     * @param user The user to be added.
     */
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Removes a user from the collection of users.
     * @param user The user to be removed.
     */
    public void removeUser(User user) {
        users.remove(user.getUsername());
    }

    /**
     * Retrieves a user from the collection of users based on the username.
     * @param username The username of the user to be retrieved.
     * @return The User object associated with the given username, or null if no such user exists.
     */
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * Checks if a user with the given username exists in the collection of users.
     * @param username The username to be checked.
     * @return true if a user with the given username exists, false otherwise.
     */
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    /**
     * Checks if the given password matches the password associated with the given username.
     * @param username The username to be checked.
     * @param password The password to be checked.
     * @return true if the password matches, false otherwise.
     */
    public boolean passwordMatches(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    /**
     * Creates a new user with the given username and password, and adds it to the collection of users.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The newly created User object.
     */
    //public User createUser(String username, String password) {
      //  User newUser = new User();
        //users.put(username, newUser);
        //return newUser;
    //}
}
