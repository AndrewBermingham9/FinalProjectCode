package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ScoreLibrary extends AppCompatActivity {

    //Value displayed on screen for each hole
    public static String[]  mHoles = new String[]  {
            "Hole 1: Partridge Hollow: Par 4",
            "Hole 2: Caul's View: Par 4",
            "Hole 3: Lambay: Par 4",
            "Hole 4: Skylark's Nest: Par 4",
            "Hole 5: Desert: Par 4",
            "Hole 6: Ridge: Par 4",
            "Hole 7: Tower: Par 4",
            "Hole 8: Well: Par 4",
            "Hole 9: Bowl: Par 3",
            "Hole 10: Quarry: Par 5",
            "Hole 11: Cricket Field: Par 4",
            "Hole 12: Valhalla: Par 4",
            "Hole 13: Broadmeadow: Par 3",
            "Hole 14: Old Clubhouse: Par 4",
            "Hole 15: Prarie: Par 5",
            "Hole 16: Andes: Par 3",
            "Hole 17: Ireland's Eye: Par 4",
            "Hole 18: Boulia Field: Par 4",
            "Great Round"
    };
    //Value of eagle score per hole
    public static int[]  mEagleScores = new int[]  {
            0,2,2,2,2,2,2,2,2,1,3,2,2,1,2,3,1,2,2
    };
    //Value of birdie score per hole
    public static int[]  mBirdieScores = new int[]  {
            0,3,3,3,3,3,3,3,3,2,4,3,3,2,3,4,2,3,3
    };
    //Value of par score per hole
    public static int[]  mParScores = new int[]  {
            0,4,4,4,4,4,4,4,4,3,5,4,4,3,4,5,3,4,4
    };
    //Value of bogey score per hole
    public static int[]  mBogeyScores = new int[]  {
            0,5,5,5,5,5,5,5,5,4,6,5,5,4,5,6,4,5,5
    };
    //Value of double bogey score per hole
    public static int[]  mDoubleBogeyScores = new int[]  {
            0,6,6,6,6,6,6,6,6,5,7,6,6,5,6,7,5,6,6
    };
    //Value of triple bogey or worse score per hole
    public static int[]  mTripleorWorseScores = new int[]  {
            0,7,7,7,7,7,7,7,7,6,8,7,7,6,7,8,6,7,7
    };

    //Value displayed on screen for each option on every hole
    private String mChoices [][] = {

            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Hole in One: 1","Birdie: 2", "Par: 3", "Bogey: 4", "Double Bogey: 5", "Triple or worse: 6+"},
            {"Eagle: 3","Birdie: 4", "Par: 5", "Bogey: 6", "Double Bogey: 7", "Triple or worse: 8+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Hole in One: 1","Birdie: 2", "Par: 3", "Bogey: 4", "Double Bogey: 5", "Triple or worse: 6+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 3","Birdie: 4", "Par: 5", "Bogey: 6", "Double Bogey: 7", "Triple or worse: 8+"},
            {"Hole in One: 1","Birdie: 2", "Par: 3", "Bogey: 4", "Double Bogey: 5", "Triple or worse: 6+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"},
            {"Eagle: 2","Birdie: 3", "Par: 4", "Bogey: 5", "Double Bogey: 6", "Triple or worse: 7+"}


    };




     public String getQuestion(int a){
         String score = mHoles[a];
         return score;
     }

     public String getChoice1(int a){
         String choice0 = mChoices[a][0];
         return choice0;
     }
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public String getChoice5(int a) {
        String choice4 = mChoices[a][4];
        return choice4;
    }
    public String getChoice6(int a) {
        String choice5 = mChoices[a][5];
        return choice5;
    }

}
