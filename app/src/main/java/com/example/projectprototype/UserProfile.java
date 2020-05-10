package com.example.projectprototype;

public class UserProfile {

    //Variable Section
    public String userAge;
    public String userEmail;
    public String userName;
    public double userHandicap;
    public String userCourse;

    public UserProfile(){

    }

    //Constructor
    public UserProfile(String userAge, String userEmail, String userName, double userHandicap, String userCourse) {
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userHandicap = userHandicap;
        this.userCourse = userCourse;


    }
    //Getters and Setters for variables
    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public double getUserHandicap(){return userHandicap;}

    public void setUserHandicap(double userHandicap){
        this.userHandicap = userHandicap;
    }

    public String getUserCourse() {return userCourse;}

    public void setUserCourse(String userCourse){
        this.userCourse = userCourse;
    }

}
