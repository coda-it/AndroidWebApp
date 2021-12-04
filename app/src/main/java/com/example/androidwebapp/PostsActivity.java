package com.example.androidwebapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androidwebapp.domain.usecases.post.PostUsecases;
import com.example.androidwebapp.domain.usecases.user.UserUsecases;

public class PostsActivity extends AppCompatActivity {
    UserUsecases userUsecases;
    PostUsecases postUsecases;

    ArrayList<String> listItems = new ArrayList<String>() {{
        add("Post 1");
        add("Post 2");
    }};
    ArrayAdapter<String> adapter;

    public PostsActivity() {
        this.userUsecases = new UserUsecases(this);
        this.postUsecases = new PostUsecases(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);

        this.postUsecases.getPosts((String value) -> {
            // load list
        });
    }
}