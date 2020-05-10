package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourseTips extends AppCompatActivity {

    //Variable Section
    private TextView Puttingtv;
    private TextView Chippingtv;
    private TextView Irontv;
    private TextView Drivingtv;
    private Button Backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_tips);

        //Variable Initialisation
        Puttingtv = (TextView) findViewById(R.id.Puttingtv);
        Chippingtv = (TextView) findViewById(R.id.Chippingtv);
        Irontv = (TextView) findViewById(R.id.Irontv);
        Drivingtv = (TextView) findViewById(R.id.Drivingtv);
        Backbtn = (Button) findViewById(R.id.Backbtn);

        Puttingtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPuttingTips();
            }
        });

        Chippingtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChippingTips();
            }
        });

        Irontv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIronTips();

            }
        });

        Drivingtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrivingTips();
            }
        });

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
    }

    //Go to Putting Tips Page
    public void openPuttingTips(){
        Intent intent = new Intent(this, PuttingTips.class);
        startActivity(intent);
    }

    //Go to Chipping Tips Page
    public void openChippingTips(){
        Intent intent  = new Intent(this, ChippingTips.class);
        startActivity(intent);
    }

    //Go to Iron Tips Page
    public void openIronTips(){
        Intent intent = new Intent(this, IronTips.class);
        startActivity(intent);
    }

    //Go to Driving Tips
    public void openDrivingTips(){
        Intent intent = new Intent(this, DrivingTips.class);
        startActivity(intent);
    }

    //Go to Home Page
    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
