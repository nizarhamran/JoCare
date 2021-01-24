package com.example.jocare.Model;

public class Reminder {

    private String name,notes,dosage,daytime, weekday, dob,time;

    public Reminder() {
    }

    public Reminder(String name, String notes, String dosage,String daytime, String weekday, String dob, String time) {
        this.name = name;
        this.notes = notes;
        this.dosage = dosage;
        this.daytime = daytime;
        this.weekday = weekday;
        this.dob = dob;
        this.time = time;
    }



    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
