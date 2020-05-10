package com.example.projectprototype;

public class Course {


    //Variable Section
    private String Name;
    private String Location;

    public Course(){

    }

    //Constructor
    public Course(String Name, String Location) {
        this.Name = Name;
        this.Location = Location;
    }


    //Getters and Setters for variables
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
