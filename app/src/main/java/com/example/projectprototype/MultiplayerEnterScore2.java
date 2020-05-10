package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerEnterScore2 extends AppCompatActivity {

    private MultiplayerScoreLibrary mMultiplayerScoreLibrary = new MultiplayerScoreLibrary();

    //Variable Section

    private TextView mScoreViewP1;
    private TextView mScoreViewP2;
    private TextView mHoleView;
    private TextView mPlayerView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;
    private Button mButtonChoice6;


    private int mScoreP1 = 0;
    private int mScoreP2 = 0;
    private int mHoleNumber = 0;
    private int mPlayerNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_enter_score2);

        //Variable Initialisation
        mScoreViewP1 = (TextView) findViewById(R.id.score);
        mScoreViewP2 = (TextView) findViewById(R.id.score2);
        mHoleView = (TextView) findViewById(R.id.question);
        mPlayerView = (TextView) findViewById(R.id.Player1);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mButtonChoice5 = (Button) findViewById(R.id.choice5);
        mButtonChoice6 = (Button) findViewById(R.id.choice6);



        //When total number of holes have been played, new page is opened and score results are displayed
        if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
            Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", mScoreP1);
            bundle.putInt("finalScore",mScoreP2);
            i.putExtras(bundle);
            MultiplayerEnterScore2.this.finish();
            startActivity(i);
        }


        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1= mScoreP1 + MultiplayerScoreLibrary.mEagleScores[mHoleNumber];
                mScoreP2= mScoreP2 + MultiplayerScoreLibrary.mEagleScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();


                Toast.makeText(MultiplayerEnterScore2.this, "Great Score!", Toast.LENGTH_SHORT).show();


            }

        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1 = mScoreP1 + MultiplayerScoreLibrary.mBirdieScores[mHoleNumber];
                mScoreP2 = mScoreP2 + MultiplayerScoreLibrary.mBirdieScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();

                Toast.makeText(MultiplayerEnterScore2.this, "Nice birdie!", Toast.LENGTH_SHORT).show();
                // }
                if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
                    Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScoreP1);
                    bundle.putInt("finalScore", mScoreP2);
                    i.putExtras(bundle);
                    MultiplayerEnterScore2.this.finish();
                    startActivity(i);
                }
            }


        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1 = mScoreP1 + MultiplayerScoreLibrary.mParScores[mHoleNumber];
                mScoreP2 = mScoreP2 + MultiplayerScoreLibrary.mParScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();

                Toast.makeText(MultiplayerEnterScore2.this, "Good par", Toast.LENGTH_SHORT).show();
                //}
                if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
                    Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScoreP1);
                    bundle.putInt("finalScore", mScoreP2);
                    i.putExtras(bundle);
                    MultiplayerEnterScore2.this.finish();
                    startActivity(i);
                }
            }

        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1 = mScoreP1 + MultiplayerScoreLibrary.mBogeyScores[mHoleNumber];
                mScoreP2 = mScoreP2 + MultiplayerScoreLibrary.mBogeyScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();

                Toast.makeText(MultiplayerEnterScore2.this, "Bogey", Toast.LENGTH_SHORT).show();
                if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
                    Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScoreP1);
                    bundle.putInt("finalScore", mScoreP2);
                    i.putExtras(bundle);
                    MultiplayerEnterScore2.this.finish();
                    startActivity(i);
                }
            }


            //}
        });

        mButtonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1 = mScoreP1 + MultiplayerScoreLibrary.mDoubleBogeyScores[mHoleNumber];
                mScoreP2 = mScoreP2 + MultiplayerScoreLibrary.mDoubleBogeyScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();

                Toast.makeText(MultiplayerEnterScore2.this, "Ouch, double bogey", Toast.LENGTH_SHORT).show();
                if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
                    Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScoreP1);
                    bundle.putInt("finalScore", mScoreP2);
                    i.putExtras(bundle);
                    MultiplayerEnterScore2.this.finish();
                    startActivity(i);
                }
            }

            //}
        });

        mButtonChoice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScoreP1 = mScoreP1 + MultiplayerScoreLibrary.mTripleorWorseScores[mHoleNumber];
                mScoreP2 = mScoreP2 + MultiplayerScoreLibrary.mTripleorWorseScores2[mHoleNumber];
                updateScore(mScoreP1);
                updateScore2(mScoreP2);
                updateQuestion();
                updatePlayer();

                Toast.makeText(MultiplayerEnterScore2.this, "Not your best, let's move on to the next", Toast.LENGTH_SHORT).show();
                if (mHoleNumber == MultiplayerScoreLibrary.mHoles.length) {
                    Intent i = new Intent(MultiplayerEnterScore2.this, MultiplayerScoreResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScoreP1);
                    bundle.putInt("finalScore", mScoreP2);
                    i.putExtras(bundle);
                    MultiplayerEnterScore2.this.finish();
                    startActivity(i);
                }
            }

            //}
        });
    }
    //When score is entered hole is updated
    private void updateQuestion() {
        mHoleView.setText(mMultiplayerScoreLibrary.getQuestion(mHoleNumber));
        mButtonChoice1.setText(mMultiplayerScoreLibrary.getChoice1(mHoleNumber));
        mButtonChoice2.setText(mMultiplayerScoreLibrary.getChoice2(mHoleNumber));
        mButtonChoice3.setText(mMultiplayerScoreLibrary.getChoice3(mHoleNumber));
        mButtonChoice4.setText(mMultiplayerScoreLibrary.getChoice4(mHoleNumber));
        mButtonChoice5.setText(mMultiplayerScoreLibrary.getChoice5(mHoleNumber));
        mButtonChoice6.setText(mMultiplayerScoreLibrary.getChoice6(mHoleNumber));




        mHoleNumber++;
    }

    //When score is entered player is updated
    private void updatePlayer(){
        mPlayerView.setText(mMultiplayerScoreLibrary.getPlayer(mPlayerNumber));



        mButtonChoice1.setText(mMultiplayerScoreLibrary.getChoice1(mPlayerNumber));
        mButtonChoice2.setText(mMultiplayerScoreLibrary.getChoice2(mPlayerNumber));
        mButtonChoice3.setText(mMultiplayerScoreLibrary.getChoice3(mPlayerNumber));
        mButtonChoice4.setText(mMultiplayerScoreLibrary.getChoice4(mPlayerNumber));
        mButtonChoice5.setText(mMultiplayerScoreLibrary.getChoice5(mPlayerNumber));
        mButtonChoice6.setText(mMultiplayerScoreLibrary.getChoice6(mPlayerNumber));


        mPlayerNumber++;

    }

    private void updateScore(int point) {
        mScoreViewP1.setText("" + mScoreP1);
    }
    private void updateScore2(int point){
        mScoreViewP2.setText("" +mScoreP2);
    }

}

