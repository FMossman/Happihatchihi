package com.example.happihatchihi.backend;

import android.app.Notification;

import com.example.happihatchihi.R;

import java.util.ArrayList;

/**
 * A class for representing a goal the user
 * is working towards.
 */
public class Goal {

    private String name;
    private int iconId;
    private int goalQuantity;
    private int goalProgress;
    private ArrayList<Notification> notifications;
    private String type;
    private String duration;

    /**
     * Constructor takes four parameters - name, iconId,
     * goalQuantity, type and duration.
     * Creates new array list to hold notifications.
     * @param name
     * @param iconId
     * @param goalQuantity
     * @param type
     * @param duration
     */

    public Goal(String name,
                int iconId,
                int goalQuantity,
                String type,
                String duration) {
        this.name = name;
        this.iconId = iconId;
        this.goalQuantity = goalQuantity;
        this.type = type;
        this.duration = duration;
        this.notifications = new ArrayList<>();
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

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
