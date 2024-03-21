package com.example.happihatchihi.backend;

import android.app.Notification;

import com.example.happihatchihi.R;

import java.util.ArrayList;

/**
 * A class for representing a goal the user
 * is working towards.
 */
public class Goal {

    // int to hold the name of the goal (could be user created or default)
    private String name;
    // int to hold the icon for a goal
    private int iconId;
    // int to show the quantity of the goal the user is aiming for
    private int goalQuantity;
    // int to show how many times user have met goal
    private int goalProgress;
    // String to show if goal is daily or weekly
    private ArrayList<HatchiWarning> warnings;
    // String to how whether gaol is one of built in types or user created
    private String type;
    // String to hold whether the goal is daily, weekly or monthly
    private String recurrence;

    /**
     * Constructor takes four parameters - name, iconId,
     * goalQuantity, type and duration.
     * Creates new array list to hold notifications.
     * @param name
     * @param iconId
     * @param goalQuantity
     * @param type
     * @param recurrence
     */

    public Goal(String name,
                int iconId,
                int goalQuantity,
                String type,
                String recurrence) {
        this.name = name;
        this.iconId = iconId;
        this.goalQuantity = goalQuantity;
        this.type = type;
        this.recurrence = recurrence;
        this.warnings = new ArrayList<>();
        this.goalProgress = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getGoalQuantity() {
        return goalQuantity;
    }

    public void setGoalQuantity(int goalQuantity) {
        this.goalQuantity = goalQuantity;
    }

    public int getGoalProgress() {
        return goalProgress;
    }

    public void setGoalProgress(int goalProgress) {
        this.goalProgress = goalProgress;
    }

    public ArrayList<HatchiWarning> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<HatchiWarning> warnings) {
        this.warnings = warnings;
    }

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

    public ArrayList<Goal> generateGoals() {
        ArrayList<Goal> goalList = new ArrayList<>();
        goalList.add(new Goal("Water",
                                R.drawable.water,
                5,
                "water",
                "daily"));
        goalList.add(new Goal("Fruit",
                R.drawable.health,
                5,
                "fruit",
                "daily"));
        goalList.add(new Goal("Meditation",
                R.drawable.meditation,
                2,
                "meditation",
                "weekly"));
        goalList.add(new Goal("Water Plants",
                R.drawable.target,
                1,
                "createyourown",
                "weekly"));
        return goalList;
    }

    public void addProgress(){
        if(this.goalProgress < this.goalQuantity) {
            this.goalProgress++;
        }
    }
}
