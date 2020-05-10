package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheIslandHole18 extends AppCompatActivity {

    //Variable Section
    private Button HomePage;
    private Button PrevHole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_island_hole18);

        //Variable Initialisation
        HomePage = (Button) findViewById(R.id.HomePage);
        PrevHole = (Button) findViewById(R.id.PrevHole);

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

        PrevHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheIslandHole17();
            }
        });
    }
    //Go to home page
    public void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    //Go to previous hole
    public void openTheIslandHole17() {
        Intent intent = new Intent(this, TheIslandHole17.class);
        startActivity(intent);
    }
}