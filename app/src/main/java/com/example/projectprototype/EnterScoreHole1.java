package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EnterScoreHole1 extends AppCompatActivity {

    //Variable Section

    private ScoreLibrary mScoreLibrary = new ScoreLibrary();

    private TextView mScoreView;
    private TextView mHoleView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;
    private Button mButtonChoice6;




    private int mScore=0;
    private int mHoleNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_score_hole1);

        //Variable Initialisation
        mScoreView = (TextView)findViewById(R.id.score);
        mHoleView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        mButtonChoice5 = (Button)findViewById(R.id.choice5);
        mButtonChoice6 = (Button)findViewById(R.id.choice6);


        updateHole();

        //When total number of holes have been played, new page is opened and score results are displayed
        if(mHoleNumber == ScoreLibrary.mHoles.length){
            Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", mScore);
            i.putExtras(bundle);
            EnterScoreHole1.this.finish();
            startActivity(i);
        }


        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    mScore = mScore + ScoreLibrary.mEagleScores[mHoleNumber];
                    updateScore(mScore);
                    updateHole();

                    Toast.makeText(EnterScoreHole1.this, "Great Score!",Toast.LENGTH_SHORT).show();



                }

        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            mScore = mScore + ScoreLibrary.mBirdieScores[mHoleNumber];
            updateScore(mScore);
                updateHole();

            Toast.makeText(EnterScoreHole1.this,"Nice birdie!", Toast.LENGTH_SHORT).show();

                if(mHoleNumber == ScoreLibrary.mHoles.length){
                    Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    EnterScoreHole1.this.finish();
                    startActivity(i);
                }
            }



        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mScore = mScore + ScoreLibrary.mParScores[mHoleNumber];
                    updateScore(mScore);
                    updateHole();

                    Toast.makeText(EnterScoreHole1.this, "Good par", Toast.LENGTH_SHORT).show();
            //}
                if(mHoleNumber == ScoreLibrary.mHoles.length){
                    Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    EnterScoreHole1.this.finish();
                    startActivity(i);
                }
            }

        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mScore = mScore + ScoreLibrary.mBogeyScores[mHoleNumber];
                    updateScore(mScore);
                    updateHole();

                    Toast.makeText(EnterScoreHole1.this, "Bogey",Toast.LENGTH_SHORT).show();
                if(mHoleNumber == ScoreLibrary.mHoles.length){
                    Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    EnterScoreHole1.this.finish();
                    startActivity(i);
                }
            }


            //}
        });

        mButtonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mScore = mScore + ScoreLibrary.mDoubleBogeyScores[mHoleNumber];
                    updateScore(mScore);
                    updateHole();

                    Toast.makeText(EnterScoreHole1.this, "Ouch, double bogey",Toast.LENGTH_SHORT).show();
                if(mHoleNumber == ScoreLibrary.mHoles.length){
                    Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    EnterScoreHole1.this.finish();
                    startActivity(i);
                }
            }

            //}
        });

        mButtonChoice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mScore = mScore + ScoreLibrary.mTripleorWorseScores[mHoleNumber];
                    updateScore(mScore);
                    updateHole();

                    Toast.makeText(EnterScoreHole1.this, "Rough hole, lets move on to the next one!",Toast.LENGTH_SHORT).show();
                if(mHoleNumber == ScoreLibrary.mHoles.length){
                    Intent i = new Intent(EnterScoreHole1.this,ScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    EnterScoreHole1.this.finish();
                    startActivity(i);
                }
            }

           // }
        });





    }

    //When score is entered hole is updated
        private void updateHole(){
            mHoleView.setText(mScoreLibrary.getQuestion(mHoleNumber));
        mButtonChoice1.setText(mScoreLibrary.getChoice1(mHoleNumber));
        mButtonChoice2.setText(mScoreLibrary.getChoice2(mHoleNumber));
        mButtonChoice3.setText(mScoreLibrary.getChoice3(mHoleNumber));
        mButtonChoice4.setText(mScoreLibrary.getChoice4(mHoleNumber));
        mButtonChoice5.setText(mScoreLibrary.getChoice5(mHoleNumber));
        mButtonChoice6.setText(mScoreLibrary.getChoice6(mHoleNumber));






            mHoleNumber++;

    }

    private void updateScore(int point){
        mScoreView.setText(""+ mScore);
    }

}
