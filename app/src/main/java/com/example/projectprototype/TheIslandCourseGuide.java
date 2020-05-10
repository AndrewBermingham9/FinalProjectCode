package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TheIslandCourseGuide extends AppCompatActivity {
    //Variable Section
    private TextView FirstHoletv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_island_course_guide);

        //Variable Initialisation
        FirstHoletv = (TextView) findViewById(R.id.FirstHoletv);


        FirstHoletv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheIslandHole1();

            }
        });
    }
    //Go to first hole of The Island Golf Course
    public void openTheIslandHole1(){
        Intent intent = new Intent(this, TheIslandHole1.class);
        startActivity(intent);
    }

}
