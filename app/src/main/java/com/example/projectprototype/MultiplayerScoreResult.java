package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplayerScoreResult extends AppCompatActivity {

    //Variable Section
    TextView Title, GrossScore, GrossScore2, NetScore, NetScore2;
    Button Submitbtn;
    EditText HandicapInputET, HandicapInput2ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_score_result);

        //Variable Initialisation
        Title = (TextView)findViewById(R.id.MyShotTracker);
        GrossScore = (TextView)findViewById(R.id.GrossScore);
        GrossScore2 = (TextView) findViewById(R.id.GrossScore2);
        HandicapInputET =(EditText)findViewById(R.id.HandicapInputET);
        HandicapInput2ET =(EditText)findViewById(R.id.HandicapInput2ET);
        NetScore = (TextView)findViewById(R.id.NetScore);
        NetScore2 = (TextView)findViewById(R.id.NetScore2);
        Submitbtn = (Button)findViewById(R.id.Submitbtn);


        //Calculating netscores of players based on gross scores and player 1 handicap
        HandicapInputET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(HandicapInputET.getText().toString());
                String x = GrossScore.getText().toString();
                int number2 = Integer.parseInt(GrossScore.getText().toString());
                int sum = number2 - number1;
                NetScore.setText( String.valueOf(sum));
            }
        });


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        GrossScore.setText(String.valueOf(score));

        //Calculating netscores of players based on gross scores and player 2 handicap
        HandicapInput2ET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(HandicapInput2ET.getText().toString());
                String x = GrossScore2.getText().toString();
                int number2 = Integer.parseInt(GrossScore2.getText().toString());
                int sum = number2 - number1;
                NetScore2.setText( String.valueOf(sum));
            }
        });

        Bundle bundle2 = getIntent().getExtras();
        int score2 = bundle2.getInt("finalScore");

        GrossScore2.setText(String.valueOf(score2));



        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });



    };
    //Go to next page
    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
