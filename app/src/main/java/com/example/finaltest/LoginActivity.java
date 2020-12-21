package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // confirming if the edit text are filled or not
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Fill All the Details ", Toast.LENGTH_SHORT).show();
        }else{
            if (username.getText().toString().equals("user1") && password.getText().toString().equals("password1")){ // if username and password is correct
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);  // go to other activity
            }
            else{    // else show the error about wrong password and username
                Toast.makeText(this, "Wrong Username Or Password", Toast.LENGTH_SHORT).show();
            }
        }

    }
}