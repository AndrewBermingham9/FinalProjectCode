package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity {
    //Variable Section
    private FirebaseAuth firebaseAuth;
    private Button logout;
    private Button MyGoals;
    private Button CourseOverview;
    private Button UploadScore;
    private Button MultiPlayerUpload;
    private Button Profile;
    private Button CourseTips;
    private Button ScoreView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Variable Initialisation
        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.Logoutbtn);
        MyGoals = (Button) findViewById(R.id.MyGoalsbtn);
        CourseOverview = (Button) findViewById(R.id.CourseOverviewbtn);
        UploadScore = (Button) findViewById(R.id.UploadScorebtn);
        MultiPlayerUpload = (Button) findViewById(R.id.MultiPlayerbtn);
        Profile = (Button) findViewById(R.id.Profilebtn);
        CourseTips = (Button) findViewById(R.id.CourseTipsbtn);
        ScoreView = (Button) findViewById(R.id.ScoreViewbtn);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();

            }
        });

        UploadScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, UploadScore.class));

            }
        });


        CourseOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, CourseOverview.class));
            }
        });


        MultiPlayerUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, MultiPlayerUpload.class));
            }
        });

        MyGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, CurrentGoals.class));
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
            }
        });

        CourseTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, CourseTips.class));
            }
        });

        ScoreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ScoreView.class));
            }
        });

    }
    //Go back to login page
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //Logout and View Profile from toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
            case R.id.profileMenu:
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
