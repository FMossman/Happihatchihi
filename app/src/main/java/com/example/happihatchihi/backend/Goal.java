package com.example.happihatchihi.backend;

public class Goal {

    //an item which represents a goal in the system
    private String goalName;
    private String goalFrequency;
    private Boolean goalIsComplete;
    private int goalID;
    private int goalProgress;

    public Goal(String goalName, String goalFrequency, Boolean goalIsComplete) {
        this.goalName = goalName;
        this.goalFrequency = goalFrequency;
        this.goalIsComplete = goalIsComplete;
    }

    public String getGoalName() {
        return goalName;
    }

    public String getGoalFrequency() {
        return goalFrequency;
    }

    public Boolean getGoalIsComplete() {
        return goalIsComplete;
    }

    public int getGoalID() {
        return goalID;
    }

    public int getGoalProgress() {
        return goalProgress;
    }

    public void setGoalName(String taskName) {
        this.goalName = goalName;
    }

    public void setGoalFrequency(String taskFrequency) {
        this.goalFrequency = goalFrequency;
    }

    public void setGoalIsComplete(Boolean taskIsComplete) {
        this.goalIsComplete = goalIsComplete;
    }

    public void setGoalID(int taskID) {
        this.goalID = goalID;
    }

    public void setGoalProgress(int taskProgress) {
        this.goalProgress = goalProgress;
    }


}
