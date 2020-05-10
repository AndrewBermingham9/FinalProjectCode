package com.example.projectprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegestrationActivity extends AppCompatActivity {

    //Variable Section
    private EditText userName, userPassword, userEmail, userAge, userHandicap, userCourse;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    String email, name, age, password, course;
    double handicap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        setupUIViews();
        //Variable Initialisation

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) ;

                //upload data to the database
                String user_email = userEmail.getText().toString().trim();
                String user_password = userPassword.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            sendEmailVerification();
                            sendUserData();
                            Toast.makeText(RegestrationActivity.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(RegestrationActivity.this, MainActivity.class));
                        }
                    }
                });
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegestrationActivity.this, MainActivity.class));
            }
        });
    }
    //Variable Initialisation
    private void setupUIViews() {
        userName = (EditText) findViewById(R.id.etUsername);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userEmail = (EditText) findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);
        userAge = (EditText) findViewById(R.id.etAge);
        userHandicap = (EditText) findViewById(R.id.etHandicap);
        userCourse = (EditText) findViewById(R.id.etCourse);




    }

    private Boolean validate(){
        Boolean result = false;

        name = userName.getText().toString();
        password = userPassword.getText().toString();
        email = userEmail.getText().toString();
        age = userAge.getText().toString();
        String strhandicap = userHandicap.getText().toString();
        handicap = Double.parseDouble(strhandicap);
        course = userCourse.getText().toString();
        //If sections are left blank verification email is not sent and account is not saved
        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || age.isEmpty()   || course.isEmpty()){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();

        }else{
            result = true;
        }
        return result;
    }
    //Send verification email to user
    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(RegestrationActivity.this, "Successfully Registered, Verification email has been sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegestrationActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(RegestrationActivity.this, "Verfication email has not been sent",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    //Get a link to the database section
    private void  sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference myRef = firebaseDatabase.getReference("Profiles/"+firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(age, email, name, handicap, course);
        myRef.setValue(userProfile);
    }


}



