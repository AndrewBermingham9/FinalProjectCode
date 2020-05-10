package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ViewHandicap extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Button AddHandicapbtn;
    EditText AddHandicapet;
    TextView HandicapHistoryTV;

     DatabaseReference dbHandicap;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_viewhandicap);

         AddHandicapet  = (EditText) findViewById(R.id.AddHandicapet);
         AddHandicapbtn = (Button) findViewById(R.id.AddHandicapbtn);
         HandicapHistoryTV = (TextView) findViewById(R.id.HandicapHistoryTV);

         String userid =null;
         FirebaseUser userx = FirebaseAuth.getInstance().getCurrentUser();
         if (userx !=null) {
             userid = userx.toString();
             String xx = userx.getUid();
             String yy = userx.getDisplayName();
             String xxx = userx.getEmail();


         }




         FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
          dbHandicap = mDatabase.getReference("Handicap");


// Read from the database
         dbHandicap.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                   // int value = dataSnapshot.getValue(int.class);
                 double values = dataSnapshot.child("addhandicapet").getValue(double.class);

               //  String x = FirebaseAuth.getInstance().getCurrentUser().getUid();

                 AddHandicapet.setText(String.valueOf(values));
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });
         HandicapHistoryTV.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(ViewHandicap.this, HandicapHistory.class));

             }
         });



         AddHandicapbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AddData();
            openSecondActivity();


        }


         });
     }



    public void AddData(){

        double addhandicapet = Double.parseDouble(AddHandicapet.getText().toString().trim());
        HandicapData handicapData = new HandicapData(addhandicapet);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        dbHandicap = mDatabase.getReference("Handicap");
        dbHandicap.setValue(handicapData);


        Toast.makeText(getApplication(),"Saved Successfully", Toast.LENGTH_LONG).show();



    }

    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);


    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(ViewHandicap.this, MainActivity.class));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }


}


