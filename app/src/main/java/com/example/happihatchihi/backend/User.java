
package com.example.happihatchihi.backend;
import java.util.ArrayList;

import com.example.happihatchihi.backend.Goal;
import com.example.happihatchihi.backend.Hatchi;


/**
 * The User class represents a user in the system.
 */
public class User {

    private String username;
    private String password;
    private String email;
    private int age;
    private String gender;
    private String firstName;
    private String lastName;
    private ArrayList<Goal> goals;
    private Boolean hatchiAlive;
    private Boolean hatchiPaused;
    private int streakCount;
    private Hatchi hatchi;

    public User(String username, String password, String email, int age, String gender, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.goals = new ArrayList<>();
        this.hatchiAlive = true;
        this.hatchiPaused = false;
        this.streakCount = 0;
        this.hatchi = new Hatchi();

    }

    /**
     * Returns the first name of the user.
     * @return the first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     * @param firstName the new first name of the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the user.
     * @return the last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName the new last name of the user.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username the new username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password the new password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of the user.
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * @param email the new email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the age of the user.
     * @return the age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     * @param age the new age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Returns the gender of the user.
     * @return the gender of the user.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     * @param gender the new gender of the user.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the goals of the user.
     * @return the goals of the user.
     */
    public ArrayList<Goal> getGoals() {
        return goals;
    }

    /**
     * Sets the goals of the user.
     * @param goals the new goals of the user.
     * @return A confirmation message of the action taken.
     */
    public String setGoals(Goal goals) {
        if (this.goals.contains(goals)) {
            return "This goal is already in your goals list!";
        }
        else {
            this.goals.add(goals);
            return "Goals updated successfully!";
        }
    }

    /**
     * Resets the user's goals by removing them.
     * @return A confirmation message of the action taken.
     */
    public  String resetGoals() {
        if (this.goals.isEmpty()) {
            return "The goals list is Empty!";
        }
        else {
            this.goals.clear();
            return "Goals reset successfully!";
        }
    }


    /**
     * Returns the alive status of the user's Hatchi.
     * @return true/false depending on if the user's Hatchi is alive/dead.
     */
    public Boolean getHatchiAlive() {
        return hatchiAlive;
    }

    /**
     * Sets alive status of the user's Hatchi.
     * @param hatchiAlive the alive status of the Hatchi.
     */
    public void setHatchiAlive(Boolean hatchiAlive) {
        this.hatchiAlive = hatchiAlive;
    }

    /**
     * Returns the pause status of the user's Hatchi.
     * @return true/false depending on if the user's Hatchi is paused/not paused.
     */
    public Boolean getHatchiPaused() {
        return hatchiPaused;
    }

    /**
     * Sets pause status of the user's Hatchi.
     * @param hatchiPaused the pause status of the Hatchi.
     */
    public void setHatchiPaused(Boolean hatchiPaused) {
        this.hatchiPaused = hatchiPaused;
    }

    /**
     * Returns the streak count of the user.
     * @return no. of days of the user has held a streak for.
     */
    public int getStreakCount() {
        return streakCount;
    }

    /**
     * Sets streak count of the user.
     */
    public void setStreakCount() {
                this.streakCount ++;
    }

    /**
     * Returns the Hatchi of the user.
     * @return the Hatchi of the user.
     */
    public Hatchi getHatchi() {
        return hatchi;
    }

    /**
     * Sets the Hatchi of the user.
     * @param hatchi the Hatchi of the user.
     */
    public void setHatchi(Hatchi hatchi) {
        this.hatchi = hatchi;
    }
}

