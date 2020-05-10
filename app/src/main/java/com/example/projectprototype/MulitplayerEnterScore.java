package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MulitplayerEnterScore extends AppCompatActivity {

    //Variable Section
    public EditText Player1Name;
    public EditText Player2Name;
    public Button Submitbtn;

    DatabaseReference databaseReference;
    public String player1name;
    public String player2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulitplayer_enter_score);

        //Variable Initialisation
        Player1Name = (EditText) findViewById(R.id.Player1Name);
        Player2Name = (EditText)findViewById(R.id.Player2Name);
        Submitbtn = (Button) findViewById(R.id.Submitbtn);

        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
                openMultiplayerEnterScore2();
            }
        });

    }
    public void AddData() {
        player1name = Player1Name.getText().toString().trim();
        player2name = Player2Name.getText().toString().trim();

   //     ((MyApplication) this.getApplication()).setM_player1name(player1name);
     //   ((MyApplication) this.getApplication()).setM_player2name(player2name);

        //       PlayerNameData playernameData = new PlayerNameData(player1name,player2name);
   //     databaseReference.push().setValue(playernameData);
     //   Toast.makeText(getApplication(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }

    //Go to next page
    public void openMultiplayerEnterScore2(){
        Intent intent = new Intent(this, MultiplayerEnterScore2.class);
        startActivity(intent);
    }


}