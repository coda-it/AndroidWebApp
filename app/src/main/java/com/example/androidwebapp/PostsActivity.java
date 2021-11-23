package com.example.androidwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidwebapp.domain.usecases.user.UserUsecases;

public class PostsActivity extends AppCompatActivity {
    UserUsecases userUsecases;

    public PostsActivity() {
        this.userUsecases = new UserUsecases(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}