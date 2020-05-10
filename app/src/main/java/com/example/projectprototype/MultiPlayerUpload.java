package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MultiPlayerUpload extends AppCompatActivity {

    //Variable Section
    private EditText EnterCourseeet;
    private Button EnterScorebtn;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_score);

        //Variable Initialisation

        EnterCourseeet  = (EditText) findViewById(R.id.EnterCourseet);
        EnterScorebtn = (Button) findViewById(R.id.EnterScorebtn);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        //Get a link to the database section
        databaseReference = firebaseDatabase.getReference().child("Profiles/"+ firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                try {
                    //  Block of code to try
                    UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);

                    //Set Value on screen
                    EnterCourseeet.setText(userProfile.getUserCourse());

                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(MultiPlayerUpload.this, "Error Setting Course", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        EnterScorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });

    }

    public void Check() {

        //Check if the course selected is valid in the app
        if (EnterCourseeet.getText().toString().equals("The Island Golf Club")){
            Toast.makeText(MultiPlayerUpload.this, "The Island Golf Club", Toast.LENGTH_SHORT).show();
            //Go to next page
            startActivity(new Intent(MultiPlayerUpload.this, MultiplayerEnterScore2.class));
        }else{
            //Output message
            Toast.makeText(this, "Course Overview not available for this golf club at this time", Toast.LENGTH_LONG).show();
        }
    }
}