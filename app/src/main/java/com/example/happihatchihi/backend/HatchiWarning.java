package com.example.happihatchihi.backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;


/**
 * The HatchiWarning class represents a warning for the Happihatchi app.
 * It contains information about the notification settings, recurrence, day, and time for the warning.
 */
public class HatchiWarning {
    private boolean notifOn;
    private boolean warningDue;
    private String recurrence;
    private int day;
    private String time;

    /**
     * Constructs a new HatchiWarning object with default values.
     * The notification is turned on, warning is due, recurrence is empty, day is 1, and time is empty.
     */
    public HatchiWarning() {
        notifOn = true;
        warningDue = true;
        recurrence = "";
        day = 1;
        time = "";
    }

    /**
     * Returns the notification status.
     * @return true if the notification is turned on, false otherwise.
     */
    public boolean isNotifOn() {
        return notifOn;
    }

    /**
     * Returns the warning status.
     * @return true if the warning is due, false otherwise.
     */
    public boolean isWarningDue() {
        return warningDue;
    }

    /**
     * Returns the recurrence of the warning.
     * @return the recurrence of the warning.
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * Returns the day of the warning.
     * @return the day of the warning.
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the time of the warning.
     * @return the time of the warning.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the notification status.
     * @param notifOn the notification status to set.
     */
    public void setNotifOn(boolean notifOn) {
        this.notifOn = notifOn;
    }

    /**
     * Sets the warning status.
     * @param warningDue the warning status to set.
     */
    public void setWarningDue(boolean warningDue) {
        this.warningDue = warningDue;
    }

    /**
     * Sets the recurrence of the warning.
     * @param recurrence the recurrence of the warning to set.
     */
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * Sets the day of the warning.
     * @param day the day of the warning to set.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Sets the time of the warning.
     * @param time the time of the warning to set.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Checks if the warning should recur and prints a message if it does.
     */
    public void recurTimer() {
        if (notifOn) {
            LocalDate today = LocalDate.now();
            if (recurrence.equals("Daily")) {
                LocalDate recurExpiry = today.plusDays(1);
                if (today.isEqual(recurExpiry)){
                    System.out.println("Goals have been renewed");
                }
            } else if (recurrence.equals( "Weekly")) {
                LocalDate recurExpiry = today.plusWeeks(1);
                if (today.isEqual(recurExpiry)){
                    System.out.println("Goals have been renewed");
                }
            }
        }
    }

    /**
     * Checks if the warning should be displayed daily and prints a message if it should.
     */
    public void dailyWarnings(){
        if (notifOn){
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("hh:mm a");
            LocalTime time1 = LocalTime.parse(time, formatter);
            LocalTime time2 = LocalTime.now();
            if (time1.equals(time2)){
                System.out.println("Goal Reminder");
            }
        }
    }

    /**
     * Checks if the warning should be displayed weekly and prints a message if it should.
     */
    public void weeklyWarnings(){
        DayOfWeek day1 = DayOfWeek.of(day);
        LocalDate today1 = LocalDate.now();
        DayOfWeek day2 = DayOfWeek.from(today1);
        if (day1.equals(day2)){
            System.out.println("Goal Reminder");
        }
    }
}