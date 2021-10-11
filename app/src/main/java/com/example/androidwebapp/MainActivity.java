package com.example.androidwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.example.androidwebapp.domain.usecases.user.UserUsecases;

public class MainActivity extends AppCompatActivity {
    UserUsecases userUsecases;

    Button loginButton;
    EditText loginTextField, passwordTextField;

    public MainActivity() {
        this.userUsecases = new UserUsecases(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.button);
        loginTextField = (EditText) findViewById(R.id.login);
        passwordTextField = (EditText) findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUsecases.login(loginTextField.getText().toString(), passwordTextField.getText().toString());
            }
        });
    }
}