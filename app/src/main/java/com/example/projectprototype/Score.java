package com.example.projectprototype;

public class Score {

    //Variable Section
    private String dateadded;
    private String handicap;
    private String grossscore;
    private String netscore;


    public Score(){

    }

    //Constructor
    public Score(String dateadded, String handicap, String grossscore, String netscore) {
        this.dateadded = dateadded;
        this.handicap = handicap;
        this.grossscore = grossscore;
        this.netscore = netscore;
    }

    //Getters and Setters for variables

    public String getDateadded() {
        return dateadded;
    }

    public void setDateadded(String dateadded) {
        this.dateadded = dateadded;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getGrossscore() {
        return grossscore;
    }

    public void setGrossscore(String grossscore) {
        this.grossscore = grossscore;
    }

    public String getNetscore() {
        return netscore;
    }

    public void setNetscore(String netscore) {
        this.netscore = netscore;
    }

    public Score(int grossscore) {





    }
}

