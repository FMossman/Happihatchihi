package com.example.happihatchihi.backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
/**
 * The HatchiWarning class encompasses the notification system for the Hatchi goal warnings.
 * It holds booleans of when a warning is due and if notifications are on,
 * as well as details for date/time.
 *
 * @author Group 1
 * @version 24/03/2023
 */

public class HatchiWarning {
    // Notifications on?
    private boolean notifOn;
    // Warning Due?
    private boolean warningDue;
    // Recurrence of a goal
    private String recurrence;
    // Day of week for goal reminder
    private int day;
    // Time of daily goal notification
    private String time;

    /**
     * Create notifications for Hatchi Warnings.
     */
    public HatchiWarning() {
        notifOn = true;
        warningDue = true;
        recurrence = "";
        day = 1;
        time = "";
    }

    /**
     * Return whether notifications are on.
     *
     * @return isNotifOn Returns whether the notifications are on
     */
    public boolean isNotifOn() {
        return notifOn;
    }

    /**
     * Return whether a warning is due for a goal.
     *
     * @return isWarningDue Returns whether a warning is due.
     */
    public boolean isWarningDue() {
        return warningDue;
    }

    /**
     * Return the recurrence set for a goal.
     *
     * @return Returns the recurrence set for a goal
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * Return the day of the week set for weekly goal reminder.
     *
     * @return Returns the day of the week as an int.
     */
    public int getDay() {
        return day;
    }

    /**
     * Return the time set for daily goal reminder.
     *
     * @return Returns the time of daily goal reminder.
     */
    public String getTime() {
        return time;
    }

    /**
     * Set whether notifications are on.
     *
     * @param notifOn Set whether notifications are on
     */
    public void setNotifOn(boolean notifOn) {
        this.notifOn = notifOn;
    }

    /**
     * Set whether warnings are due
     *
     * @param warningDue Set whether warnings are due
     */
    public void setWarningDue(boolean warningDue) {
        this.warningDue = warningDue;
    }

    /**
     * Set the recurrence of a goal
     *
     * @param recurrence Set recurrence of a goal
     */
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * Set the day of the week for a weekly goal reminder
     *
     * @param day Set day of the week for a weekly goal reminder
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Set the time for a daily goal reminder
     *
     * @param time Set the time for a daily goal reminder
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Begins the timer for a goal based on the recurrence set by user
     *
     * @return Will notify user when timer is up and goals are reset
     */
    public String goalTimer() {
        String outputString = "";
        if (notifOn) {
            LocalDate today = LocalDate.now();
            if (recurrence.equals("Daily")) {
                LocalDate recurExpiry = today.plusDays(1);
                if (today.isEqual(recurExpiry)) {
                    outputString = "Goals have been renewed";
                    return outputString;
                }
            } else if (recurrence.equals("Weekly")) {
                LocalDate recurExpiry = today.plusWeeks(1);
                if (today.isEqual(recurExpiry)) {
                    outputString = "Goals have been renewed";
                    return outputString;
                }
            }
        } return outputString;
    }

    /**
     * Formats the time from time input for daily goal warnings
     *
     * @return Daily goal warning notification
     */
    public String dailyWarnings(){
        String outputString1 = "";
        if (notifOn){
            DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("hh:mm a");
            LocalTime time1 = LocalTime.parse(time, formatter);
            LocalTime time2 = LocalTime.now();
            if (time1.equals(time2)){
                outputString1 = "Goal Reminder";
                return outputString1;
            }
        } return outputString1;
    }

    /**
     * Formats the day from day input for weekly goal warnings
     *
     * @return Weekly goal warning notification
     */
    public String weeklyWarnings(){
        String outputString2 = "";
        DayOfWeek day1 = DayOfWeek.of(day);
        LocalDate today1 = LocalDate.now();
        DayOfWeek day2 = DayOfWeek.from(today1);
        if (day1.equals(day2)){
            outputString2 = "Goal Reminder";
            return outputString2;
        } return outputString2;
    }
}