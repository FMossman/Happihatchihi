package com.example.happihatchihi.backend;

import com.example.happihatchihi.backend.HatchiWarning;

import java.util.ArrayList;

/**
 * A class for representing a goal the user
 * is working towards.
 */
public class Goal {

    private final ArrayList<Object> goals;
    private ArrayList<HatchiWarning> warnings;
    // int to hold the name of the goal (could be user created or default)
    private String name;
    // int to show the quantity of the goal the user is aiming for
    private int goalQuantity;
    // int to show how many times user have met goal
    private int goalProgress;
    // String to show if goal is daily or weekly
    private String recurrence;
    // String to know whether goal is one of built-in types or user created
    private String type;
    // boolean to hold whether a goal has been achieved
    private boolean goalAchieved;

    /**
     * Constructor takes four parameters - name,
     * goalQuantity, type and duration.
     * Creates new array list to hold warnings.
     *
     * @param name  The name of the goal
     * @param goalQuantity  The target number of times the user wants to do the goal
     * @param type  The type of goal
     * @param recurrence    The recurrence level - daily or weekly
     */
    public Goal(String name,
                int goalQuantity,
                String type,
                String recurrence) {
        this.name = name;
        this.goalQuantity = goalQuantity;
        this.type = type;
        this.goals = new ArrayList<>();
        this.recurrence = recurrence;
        //this.warnings = new ArrayList<>();
        this.goalProgress = 0;
        this.goalAchieved = false;


    }

    /**
     * This is a method for accessing the name of a goal.
     *
     * @return name The name of the goal
     */
    public String getName() {
        return name;
    }

    /**
     * This is a method for modifying the name of a goal.
     * @param name The name of the gaol
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a method for accessing the goal quantity.
     *
     * @return goalQuantity The quantity of the goal
     */
    public int getGoalQuantity() {
        return goalQuantity;
    }

    /**
     * This is a method for modifying the goal quantity.
     *
     * @param goalQuantity The quantity of the goal
     */
    public void setGoalQuantity(int goalQuantity) {
        this.goalQuantity = goalQuantity;
    }

    /**
     * This is a method for accessing the goal progress.
     *
     * @return goalProgress The progress of the goal
     */
    public int getGoalProgress() {
        return goalProgress;
    }
    /**
     * This is a method for setting the goal progress.
     *
     * @param goalProgress The progress of the goal
     */
    public void setGoalProgress(int goalProgress) {
        this.goalProgress = goalProgress;
    }

    /**
     * This is a method for accessing a list of Hatchi warnings.
     *
     * @return warnings The list of Hatchi warnings
     */
    public ArrayList<HatchiWarning> getWarnings() {
        return warnings;
    }

    /**
     * This is a method for setting the list of warnings.
     *
     * @param warnings list of warnings
     */
    public void setWarnings(ArrayList<HatchiWarning> warnings) {
        this.warnings = warnings;
    }

    /**
     * This is a method for accessing goal type.
     *
     * @return type The type of goal
     */
    public String getType() {
        return type;
    }

    /**
     * This is a method for setting the type of goal.
     *
     * @param type The type of goal
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This is a method for accessing the recurrence of a goal.
     *
     * @return reccurrence The recurrence of the goal
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * This is a method for setting the recurrence of a goal.
     *
     * @param recurrence The recurrence of the goal
     */
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * This is a method for accessing whether a goal is achieved.
     *
     * @return goalAchieved Whether a goal is achieved
     */
    public boolean isGoalAchieved() {
        return goalAchieved;
    }
    /**
     * This is a method for setting whether a goal has been achieved.
     *
     * @param goalAchieved Whether a goal has been achieved
     */
    public void setGoalAchieved(boolean goalAchieved) {
        this.goalAchieved = goalAchieved;
    }

    /**
     * This is a method for generating a list of goals for testing purposes.
     *
     * @return goalList An arraylist of goal objects.
     */
    public ArrayList<Goal> generateGoals() {
        ArrayList<Goal> goalList = new ArrayList<>();
        goalList.add(new Goal("Water",
                5,
                "water",
                "daily"));
        goalList.add(new Goal("Fruit",
                5,
                "fruit",
                "daily"));
        goalList.add(new Goal("Meditation",
                2,
                "meditation",
                "weekly"));
        goalList.add(new Goal("Water Plants",
                1,
                "createyourown",
                "weekly"));
        return goalList;
    }

    /**
     * This is a method for tracking progress of a goal.
     */
    public void addProgress(){
        if(this.goalProgress < this.goalQuantity) {
            this.goalProgress++;
        }
    }

    /**
     * This is a method for updating whether a warning is due from the list of warnings.
     *
     * @param hatchiWarning HatchiWarning object
     */
    public void updateWarningDue(HatchiWarning hatchiWarning){
        for (HatchiWarning warning: warnings){
            if (hatchiWarning.isWarningDue()) {
                if(this.goalProgress == this.goalQuantity){
                    hatchiWarning.setWarningDue(false);
                }
            }
        }
    }

    /**
     * This is a method for adding a warning to the list of warnings.
     *
     * @param hatchiWarning HatchiWarning object
     */
    public void addWarning(HatchiWarning hatchiWarning){
        if(!warnings.contains(hatchiWarning))
        {
            warnings.add(hatchiWarning);
        }

    }

    /**
     * This is a method for removing a warning to the list of warnings.
     *
     * @param hatchiWarning HatchiWarning object
     */
    public void deleteWarning(HatchiWarning hatchiWarning) {
        if(warnings.contains(hatchiWarning))
        {
            warnings.remove(hatchiWarning);
        }
    }

    /**
     * This is a method for updating the fields of a warning in the list of warnings.
     *
     * @param hatchiWarning HatchiWarning object
     * @param newRecurrence updated recurrence
     * @param newTime updated time of daily warnings
     * @param newDay updated day of weekly warnings
     * @param newNotifOn update whether user wants to receive warning notifications
     */
    public void editWarning(HatchiWarning hatchiWarning, String newRecurrence, String newTime,
                            int newDay, boolean newNotifOn)
    {
        if (warnings.contains(hatchiWarning))
        {
            hatchiWarning.setDay(newDay);
            hatchiWarning.setRecurrence(newRecurrence);
            hatchiWarning.setTime(newTime);
            hatchiWarning.setNotifOn(newNotifOn);
        }
    }

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
     * Removes a selected goal.
     * @param goal the Goal to be removed.
     * @return A confirmation message of the action taken.
     */

    public  String removeGoals(Goal goal) {
        this.goals.remove(goal);
        return goal +  " has been removed!";
    }


    /**
     * Resets the user's goals by removing them.
     * @return A confirmation message of the action taken.
     */


    public void removeProgress() {
    }
}