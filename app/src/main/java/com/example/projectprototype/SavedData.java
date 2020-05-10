package com.example.projectprototype;

import java.util.Date;

public class SavedData {

    private SavedData(){

    }
    //Variable Section
    String GoalInput;
    String SelectDatetv;
    String dateadded;

    //Constructor
    public SavedData (String GoalInput,String SelectDatetv, String dateadded){

        this.GoalInput = GoalInput;
        this.SelectDatetv = SelectDatetv;

    }

    //Getters and Setters for Variables

    public String getselectdatetv() {return SelectDatetv;}

    public void setselecttv (String SelectDatetv) {this.SelectDatetv = SelectDatetv;}


    public String getgoalinput() {return GoalInput;}

    public void setgoalinput(String GoalInput) {this.GoalInput = GoalInput;}

    public String getDateadded() {return dateadded;}

    public void setDateadded(String dateadded) {this.dateadded = dateadded;}


}
