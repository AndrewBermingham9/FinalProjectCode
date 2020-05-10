package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
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

public class UpdateProfile extends AppCompatActivity {

    //Variable Section
    private EditText newUserName, newUserEmail, newUserAge, newUserHandicap, newUserCourse;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        //Variable Initialisation
        newUserName = (EditText)findViewById(R.id.etNameUpdate);
        newUserEmail = (EditText)findViewById(R.id.etEmailUpdate);
        newUserAge = (EditText) findViewById(R.id.etAgeUpdate);
        newUserHandicap = (EditText) findViewById(R.id.etHandicapUpdate);
        newUserCourse = (EditText) findViewById(R.id.etCourseUpdate);


        save= (Button) findViewById(R.id.btnSave);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        //Get a link to the database section
        final DatabaseReference databaseReference = firebaseDatabase.getReference("Profiles/"+firebaseAuth.getUid());


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    //  Block of code to try
                    UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);

                    //Set Profile Value on screen

                    newUserName.setText(userProfile.getUserName());
                    newUserAge.setText(userProfile.getUserAge());
                    newUserEmail.setText(userProfile.getUserEmail());

                    double x = userProfile.getUserHandicap();
                    newUserHandicap.setText(String.valueOf(x));


                    newUserCourse.setText(userProfile.getUserCourse());
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(UpdateProfile.this, "Error Updating User Profile", Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateProfile.this, databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = newUserName.getText().toString();
                String age = newUserAge.getText().toString();
                String email = newUserEmail.getText().toString();
                String strhandicap = newUserHandicap.getText().toString();
                double handicap = Double.parseDouble(strhandicap);
                String course = newUserCourse.getText().toString();

                UserProfile userProfile = new UserProfile(age, email, name, handicap, course);

                databaseReference.setValue(userProfile);

                finish();
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
