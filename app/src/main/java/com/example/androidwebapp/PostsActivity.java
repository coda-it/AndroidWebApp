package com.example.androidwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import android.os.Bundle;

import com.example.androidwebapp.domain.usecases.post.PostUsecases;
import com.example.androidwebapp.domain.usecases.user.UserUsecases;

public class PostsActivity extends AppCompatActivity {
    UserUsecases userUsecases;
    PostUsecases postUsecases;

    public PostsActivity() {
        this.userUsecases = new UserUsecases(this);
        this.postUsecases = new PostUsecases(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        this.postUsecases.getPosts((String value) -> {
            // load list
        });
    }
}