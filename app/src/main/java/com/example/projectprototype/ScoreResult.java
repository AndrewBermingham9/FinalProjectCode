package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ScoreResult extends AppCompatActivity
{

    //Variable Section
    TextView Title, GrossScore, NetScore, textViewDate;
    Button Submitbtn;
    EditText HandicapInputET;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    int lastchildnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_result);


        //Variable Initialisation
        Title = (TextView)findViewById(R.id.MyShotTracker);
        GrossScore = (TextView)findViewById(R.id.GrossScore);
        HandicapInputET =(EditText)findViewById(R.id.HandicapInputET);
        Submitbtn = (Button)findViewById(R.id.Submitbtn);
        NetScore = (TextView)findViewById(R.id.NetScore);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        ShowHandicap();

        //Get a link to the database section
        databaseReference = firebaseDatabase.getReference().child("Scores/"+ firebaseAuth.getUid());


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                lastchildnumber = 0;
                try {
                    //  Block of code to try
                    for (DataSnapshot ds : dataSnapshot.getChildren())
                    {

                        String scorename = ds.getKey();

                        int lengthofgoal = ds.getKey().length();



                        lastchildnumber = Integer.parseInt(scorename.substring(8,(lengthofgoal)));


                    }
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(ScoreResult.this, "Error Setting Course", Toast.LENGTH_SHORT).show();

                }



                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


            Bundle bundle = getIntent().getExtras();
            int score = bundle.getInt("finalScore");

        GrossScore.setText(String.valueOf(score));


        Submitbtn.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                AddData();
                openSecondActivity();
            }
            });


        };
        public void AddData(){


            Boolean handicapchange = FALSE;
            Double newhandicap = 0.0;

            CalculateNetScore();
            Calendar calendar = Calendar.getInstance();

            String grossscore = GrossScore.getText().toString().trim();
            String netscore = NetScore.getText().toString().trim();
            String handicap = HandicapInputET.getText().toString().trim();
            String dateadded = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
            Score score = new Score(dateadded, handicap, grossscore, netscore);

            String scorename = "/Score - " + String.valueOf(lastchildnumber+1);

            DatabaseReference scoreref = firebaseDatabase.getReference("Scores/"+firebaseAuth.getUid()+scorename);

            scoreref.setValue(score);


            //Check if Handicap needs to be altered
            //If netscore > 71 0.1 is added to user's handicap
            //If netscore <71 0.1 is deducted from user's handicap
            //If netscore =71 users handicap remains the same

            if (Integer.parseInt(netscore) > 71)
            {
                double x = Double.parseDouble(handicap);
                newhandicap = x+0.1;
                handicapchange = TRUE;
            }
            else if (Integer.parseInt(netscore) < 71)
            {
                double x = Double.parseDouble(handicap);
                newhandicap = x-0.1;
                handicapchange = TRUE;
            }
            //Alter Handicap in profile page based on netscore calculated
            if (handicapchange == TRUE)
            {
                DatabaseReference profileref;

                profileref = firebaseDatabase.getReference().child("Profiles/" + firebaseAuth.getUid()).child("userHandicap");

                profileref.setValue(newhandicap);
            }


            Toast.makeText(getApplication(),"Saved Successfully", Toast.LENGTH_LONG).show();

    }


    public void ShowHandicap() {

        //Go to Profile of user in database to retrieve handicap and display on screen
        DatabaseReference ProfileDatabase;
        ProfileDatabase = firebaseDatabase.getReference().child("Profiles/" + firebaseAuth.getUid());

        ProfileDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    //  Block of code to try
                    //Get User's profile
                    UserProfile userprofile = dataSnapshot.getValue(UserProfile.class);

                    //Set  Value on screen

                    //Get user's handicap
                    Double handicap = userprofile.getUserHandicap();

                    //Display on screen
                    HandicapInputET.setText(Double.toString(handicap));
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(ScoreResult.this, "Error Setting Result", Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }



public void CalculateNetScore() {

    double handicap = Double.parseDouble(HandicapInputET.getText().toString());

    int grossscore = Integer.parseInt(GrossScore.getText().toString());

    //Calculate Net Score
    double sum = grossscore - handicap;

    // Round score to be a whole number
    int rounded = (int) Math.round(sum);

    NetScore.setText(String.valueOf(rounded));
}

    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}