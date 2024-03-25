package com.example.happihatchihi.backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;


public class HatchiWarning {
    private boolean notifOn;
    private boolean warningDue;
    private String recurrence;
    private int day;
    private String time;


    public HatchiWarning() {
        notifOn = true;
        warningDue = true;
        recurrence = "";
        day = 1;
        time = "";
    }

    public boolean isNotifOn() {
        return notifOn;
    }

    public boolean isWarningDue() {
        return warningDue;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public void setNotifOn(boolean notifOn) {
        this.notifOn = notifOn;
    }

    public void setWarningDue(boolean warningDue) {
        this.warningDue = warningDue;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String recurTimer() {
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