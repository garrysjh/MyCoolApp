package com.example.mycoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, firstname,lastname, mobile;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Hook Edit Text Fields
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);
        mobile = findViewById(R.id.Mobile);

        //Hook RegisterButton:
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                processRegisterFields();

            }
        });

    }

    //process form
    public void processRegisterFields(){
        if (validateUserName()||validatePassword()||validateFirst()||validateLast()||validateMobile()){
            return;
        }


        Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();

    }
    //input validation
    public boolean validateUserName(){
        String givenUsername = username.getText().toString();

        if(givenUsername.isEmpty()){
            username.setError("Username can't be empty!");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }
    public boolean validatePassword(){
        String givenPass = password.getText().toString();

        if(givenPass.isEmpty()){
            password.setError("Password can't be empty!");
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }
    public boolean validateFirst(){
        String givenFirst = firstname.getText().toString();

        if(givenFirst.isEmpty()){
            firstname.setError("First name can't be empty!");
            return false;
        }else{
            firstname.setError(null);
            return true;
        }
    }
    public boolean validateLast(){
        String givenLast = lastname.getText().toString();

        if(givenLast.isEmpty()){
            lastname.setError("Last name can't be empty!");
            return false;
        }else{
            lastname.setError(null);
            return true;
        }
    }
    public boolean validateMobile(){
        String givenMobile = mobile.getText().toString();

        if(givenMobile.isEmpty()){
            mobile.setError("Username can't be empty!");
            return false;
        }else{
            mobile.setError(null);
            return true;
        }
    }
}