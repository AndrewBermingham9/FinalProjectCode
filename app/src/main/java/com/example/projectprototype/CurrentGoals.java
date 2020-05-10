package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.graphics.Color.CYAN;


public class CurrentGoals extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    //Variable Section
    private Button Savebtn;
    private Button Datebtn;
    private Button Deletebtn;
    private EditText GoalInput;
    private TextView SelectDatetv;


    ListView GoalslistView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;


    View updateview;// above oncreate method



    Goal goal;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    //Variables for storing Childnames

    //Used for clearing a goal
    ArrayList<String> Childnames;
    int ListPosition = -1;
    int lastchildnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_goals);

        //Variable Initialisation

        goal = new Goal();

        GoalslistView = (ListView) findViewById(R.id.GoalslistView);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        //Buttons on screen
        Savebtn = (Button) findViewById(R.id.save);
        Datebtn = (Button) findViewById(R.id.Datebtn);
        Deletebtn = (Button) findViewById(R.id.Deletebtn);

        //Fields on screen
        GoalInput = (EditText) findViewById(R.id.GoalInput);
        SelectDatetv = (TextView) findViewById(R.id.SelectDatetv);


        list = new ArrayList<>();
        Childnames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.goal_info, R.id.GoalInfo, list);

        GoalslistView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        DatabaseReference goalref = firebaseDatabase.getReference("Goals/" + firebaseAuth.getUid());

        //Display Current Goals
        goalref.addValueEventListener(new ValueEventListener() {
            //Loop through the nodes
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Initializing Childnames Variables

                Childnames.clear();
                list.clear();
                lastchildnumber = 0;

                try {
                    //  Block of code to try
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        //Add entry to child names array
                        Childnames.add(ds.getKey());

                        //Find goal number
                        String goalname = ds.getKey();
                        int lengthofgoal = ds.getKey().length();

                        //Set variable to be number of the goal
                        lastchildnumber = Integer.parseInt(goalname.substring(7,(lengthofgoal)));

                        goal = ds.getValue(Goal.class);


                        //Add entry to list array
                        list.add(goal.getDateadded().toString() + "          " + goal.getGoal().toString() + "          " + goal.getDatecompleted().toString());
                    }
                    //Display list on screen
                    GoalslistView.setAdapter(adapter);

                }
                catch(Exception e) {
                    //  Block of code to handle errors
                    Toast.makeText(CurrentGoals.this, "Error Setting Goal", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CurrentGoals.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }


        });







        //Get current item for listview
        GoalslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                    ListPosition = position;

                                                    for(int i=0; i<GoalslistView.getAdapter().getCount();i++)
                                                     {
                                                         GoalslistView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                                                     }

                                                     parent.getChildAt(position).setBackgroundColor(Color.WHITE);


                                                 }
                                             }
        );


        //Display Calendar
        Datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

        //Delete Goal from database
        Deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the reference to the node in the database

                if (ListPosition > -1)
                {
                    DatabaseReference goalref = firebaseDatabase.getReference("Goals/" + firebaseAuth.getUid() + "/" + Childnames.get(ListPosition));

                    goalref.removeValue();

                    ListPosition = -1;

                }

            }
        });


        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();

            }
        });

    }


    public void AddData() {

        Calendar calendar = Calendar.getInstance();

        String goalinput = GoalInput.getText().toString().trim();
        String selectdatetv = SelectDatetv.getText().toString().trim();
        String dateadded = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        Goal goal = new Goal(dateadded, goalinput, selectdatetv);

        String goalname = "/Goal - " + String.valueOf(lastchildnumber+1);


        DatabaseReference goalref = firebaseDatabase.getReference("Goals/"+firebaseAuth.getUid()+goalname);


        goalref.setValue(goal);

        Toast.makeText(getApplication(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }

    @Override

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView SelectDatetv = (TextView) findViewById(R.id.SelectDatetv);
        SelectDatetv.setText(currentDateString);


    }


}
