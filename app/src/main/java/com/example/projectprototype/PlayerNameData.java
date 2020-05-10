package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PlayerNameData  {

    PlayerNameData(String player1name, String player2name){

    }
    //Variable Section
    String Player1Name;
    String Player2Name;



    //Getters and setter for variables
    public String getPlayer1Name() {
        return Player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        Player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return Player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        Player2Name = player2Name;
    }
}



