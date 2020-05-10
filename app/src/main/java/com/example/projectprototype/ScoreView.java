package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScoreView extends AppCompatActivity {
    private Button Backbtn;


    //Variable declaration
    ListView ScoreListView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Score score;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);

        //Initialise variables
        score = new Score();
        list = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        //Connect to Score History in Database
        DatabaseReference scoreref = firebaseDatabase.getReference("Scores/" + firebaseAuth.getUid());

        //ListView to show Score history
        ScoreListView = (ListView) findViewById(R.id.ScoreListView);

        //Buttons on screen
        Backbtn = (Button) findViewById(R.id.Backbtn);

        //Attach list array to the adapter
        adapter = new ArrayAdapter<String>(this, R.layout.score_info, R.id.ScoreInfo, list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        scoreref.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                //Clear the list array of scores
                list.clear();

                try {
                    //  Block of code to try
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        //Integer x = Math.toIntExact(ds.getChildrenCount());

                        //Get next score from database
                        score = ds.getValue(Score.class);

                        //Populate the list array with the score details
                        list.add(score.getDateadded().toString() + "            " + score.getHandicap().toString() + "                   " + (String) score.getGrossscore() + "                        " + score.getNetscore().toString()) ;
                    }

                    //Display the new list
                    ScoreListView.setAdapter(adapter);
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(ScoreView.this, "Error Displaying Score", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ScoreView.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

    }

    //Go to Home Page
    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
