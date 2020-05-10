package com.example.projectprototype;

public class Goal {

    //Variable Section
    private String dateadded;
    private String goal;
    private String datecompleted;

    public Goal(){

    }

    //Constructor
    public Goal(String dateadded, String goal, String datecompleted) {
        this.dateadded = dateadded;
        this.goal = goal;
        this.datecompleted = datecompleted;
    }

    //Getters and Setters for variables
    public String getDateadded() {
        return dateadded;
    }

    public void setDateadded(String dateadded) {
        this.dateadded = dateadded;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDatecompleted() {
        return datecompleted;
    }

    public void setDatecompleted(String datecompleted) {
        this.datecompleted = datecompleted;
    }
}
