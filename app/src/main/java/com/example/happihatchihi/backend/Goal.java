package com.example.happihatchihi.backend;


import java.util.ArrayList;

/**
 * A class for representing a goal the user
 * is working towards.
 */
public class Goal {

    private ArrayList<HatchiWarning> warnings;
    // int to hold the name of the goal (could be user created or default)
    private String name;
    // int to show the quantity of the goal the user is aiming for
    private int goalQuantity;
    // int to show how many times user have met goal
    private int goalProgress;
    // String to show if goal is daily or weekly
    //private ArrayList<HatchiWarning> warnings;
    // String to how whether gaol is one of built in types or user created
    private String type;
    // String to hold whether the goal is daily, weekly or monthly
    private String recurrence;
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


    public int getGoalProgress() {
        return goalProgress;
    }

    public void setGoalProgress(int goalProgress) {
        this.goalProgress = goalProgress;
    }

    //public ArrayList<HatchiWarning> getWarnings() {
        //return warnings;
    //}

    //public void setWarnings(ArrayList<HatchiWarning> warnings) {
     //   this.warnings = warnings;
    //}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public boolean isGoalAchieved() {
        return goalAchieved;
    }

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

    public void removeProgress(){
        if(this.goalProgress > 0) {
            this.goalProgress--;
        }
    }

    //public void checkGoalStatus(){
    //    for ( HatchiWarning warning : warnings) {

     //   }
    //}
}

